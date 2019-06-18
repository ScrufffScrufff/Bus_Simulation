import java.util.ArrayList;

/**
 * Created by xain on 11/20/2016.
 */
public class BusEvent implements Event {
    private Bus bus;
    private String stop;
    private static String direction = "east";
    private static String[] randomstop = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street", "Minnesota Street and 4th Street", "Union Depot", "Union Depot"};
    private static String[] p = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street", "Union Depot"};
    private int count;
    private int eastadded = 0, westadded =0;
    private ArrayList<Passenger> eastremoved,westremoved;

    public BusEvent(Bus bus, String stop, int count) {
        this.bus = bus;
        this.stop = stop;
        this.count = count;
    }

    public void run() {
        //System.out.println(stop + " time : " + BusSim.agenda.getCurrentTime() + " : " + count + " cargo: " + bus.getCargo()); //can enable this to see stuff
        if (direction.equals("east") && count == 9) { // if we're at the end of the line and our direction is still east; go the other way
            direction = "west";
        }
        if (direction.equals("west") && count == 0) { // if we're at the beginning of the line and our direction is west; go the other way
            direction = "east";
        }
        if (direction.equals("west")) { // if we're going west
            westremoved = bus.removePassengersAtStop(stop); //remove people from the bus
            Stat.updateNumberOfPeopleGotOnBus(westremoved.size()); //update how many were removed
            for(int i = 0; i < westremoved.size();i++){
                westremoved.get(i).setExitBusTime(BusSim.agenda.getCurrentTime()); // for each person set the time that they were removed at
                //update some stats, go look at it might be wrong
                Stat.updatePassengerTimeStats(westremoved.get(i).getBusTime(),westremoved.get(i).getLineEntryTime(),westremoved.get(i).getExitBusTime());
            }
            switch (stop) { // this is where we look at queues and see if we can put more people on our bus
                case "University Ave and 27th Street SE":
                    while (PeopleInQueue.twentyseventh.westLength() > 0 && !bus.isFull()) { //while we have people in queue and our bus isnt full
                        bus.addPassenger((Passenger) PeopleInQueue.twentyseventh.getWest().remove()); // add a person that we remove from a queue to the bus
                        westadded++; //updating the number of people we removed
                    }
                    break;
                case "Raymond Ave Station":
                    while (PeopleInQueue.raymond.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.raymond.getWest().remove());
                        westadded++;
                    }
                    break;
                case "University Ave and Fairview Ave":
                    while (PeopleInQueue.fairview.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.fairview.getWest().remove());
                        westadded++;
                    }
                    break;
                case "University Ave and Snelling Ave":
                    while (PeopleInQueue.snelling.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.snelling.getWest().remove());
                        westadded++;
                    }
                    break;
                case "University Ave and Lexington Parkway":
                    while (PeopleInQueue.lexington.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.lexington.getWest().remove());
                        westadded++;
                    }
                    break;
                case "University Ave and Dale Street":
                    while (PeopleInQueue.dale.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.dale.getWest().remove());
                        westadded++;
                    }
                    break;
                case "University Ave and Marion Street":
                    while (PeopleInQueue.marion.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.marion.getWest().remove());
                        westadded++;
                    }
                    break;
                case "Cedar Street and 5th Street":
                    while (PeopleInQueue.cedar.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.cedar.getWest().remove());
                        westadded++;
                    }
                    break;
                case "Minnesota Street and 4th Street":
                    while (PeopleInQueue.minnesota.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.minnesota.getWest().remove());
                        westadded++;
                    }
                    break;
                case "Union Depot":
                    while (PeopleInQueue.union.westLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.union.getWest().remove());
                        westadded++;
                    }
                    break;
            }
            count--; //moving to the next bus stop
            stop = p[count]; // the next bus stop
            //making a new bus event that has the current stop and out bus at a time in the future that is determined by the base time and then how many people got on/off * the respective times they take
            BusSim.agenda.add(new BusEvent(bus, stop, count), 180 + 15 +(westremoved.size()*2)+(westadded*3));
        }

        //POSSIBLE FAILURE
        if (direction.equals("east")) { //same thing but for the east AGAIN MIGHT NOT BE CORRECT EVERYTHING SEEMS SO OFFFFFFF
            eastremoved = bus.removePassengersAtStop(stop);
            Stat.updateNumberOfPeopleGotOnBus(eastremoved.size());
            for(int i = 0; i < eastremoved.size();i++){
                eastremoved.get(i).setExitBusTime(BusSim.agenda.getCurrentTime());
                Stat.updatePassengerTimeStats(eastremoved.get(i).getBusTime(),eastremoved.get(i).getLineEntryTime(),eastremoved.get(i).getExitBusTime());
            }
            switch (stop) {
                case "University Ave and 27th Street SE":
                    while (PeopleInQueue.twentyseventh.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.twentyseventh.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "Raymond Ave Station":
                    while (PeopleInQueue.raymond.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.raymond.getEast().remove());
                        eastadded++;

                    }
                    break;
                case "University Ave and Fairview Ave":
                    while (PeopleInQueue.fairview.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.fairview.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "University Ave and Snelling Ave":
                    while (PeopleInQueue.snelling.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.snelling.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "University Ave and Lexington Parkway":
                    while (PeopleInQueue.lexington.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.lexington.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "University Ave and Dale Street":
                    while (PeopleInQueue.dale.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.dale.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "University Ave and Marion Street":
                    while (PeopleInQueue.marion.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.marion.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "Cedar Street and 5th Street":
                    while (PeopleInQueue.cedar.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.cedar.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "Minnesota Street and 4th Street":
                    while (PeopleInQueue.minnesota.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.minnesota.getEast().remove());
                        eastadded++;
                    }
                    break;
                case "Union Depot":
                    while (PeopleInQueue.union.eastLength() > 0 && !bus.isFull()) {
                        bus.addPassenger((Passenger) PeopleInQueue.union.getEast().remove());
                        eastadded++;
                    }
                    break;
            }
            count++;
            stop = p[count];
            BusSim.agenda.add(new BusEvent(bus, stop, count), 180 + 15 +(eastremoved.size()*2)+(eastadded*3));

        }
    }
}
