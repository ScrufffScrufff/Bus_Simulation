import java.util.ArrayList;

/**
 * Created by xain on 11/20/2016.
 */
public class Bus {
    private ArrayList<Passenger> passengers = new ArrayList(); // modify this either 40/60 only
    //private int numberOfPassengers = 0; //counts for buses' people

    public boolean addPassenger(Passenger p){
        if (isFull()) {
            return false;
        }
        passengers.add(p); // adding people to the bus at the spot they neeed to be in
        //numberOfPassengers++; // increasing number of people on the bus
        p.setBusTime(BusSim.agenda.getCurrentTime()); // update the time he actually got on the bus
        return true;
    }

    public int getCargo(){
        return passengers.size();
    }
    public ArrayList<Passenger> removePassengersAtStop(String stop){ //arraylists are amazing
        int count = 0; // for stat purposes
        ArrayList<Passenger> p = new ArrayList<>();
        if(passengers!=null){
            for(int i = 0; i < passengers.size(); i++){
                if(passengers.get(i).getDropoff() == stop){ //if the guy wants to get off here
                    count++; //increase # of people getting off
                    p.add(passengers.get(i));
                    passengers.remove(i);
                    // adding people to the output arraylist
                    //busList[i]= null; // i think i messed up here; in fact i did so bad. if i set a dude to null and he was like 3 in but we have a 5 long list then i've just cut off the last dude too...
                    //ARRAY LISTS FOR EVERYTHIIIINGGGGG
                    //numberOfPassengers--;
                }
            }
            Stat.updateBusCount(count);
        }
        return p;
    }
    public boolean isFull(){
        if (passengers.size() == 60){//dont forget to change this to like 40 or w/e when messing with busses

            return true;
        }
        return false;
    }
}
