import java.util.Random;

/**
 * Created by xain on 11/20/2016.
 */
public class PassengerEvent implements Event {
    // 100 long don't want to compress
    private int stop;
    public static int count;
    private int[] times = new int[]{210,210,210,210,210,210,210,210,210,210,180,180,180,180,180,180,180,180,180,180,180,180,180,180,180,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,144,120,120,120,120,120,120,120,120,120,120,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,96,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,30,30,30,30,30,30,30,30,30,30};
    private String[] p = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street", "Minnesota Street and 4th Street", "Union Depot", "Union Depot"};
    private String[] base = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street","Union Depot"};
    public void run(){
        count++;
        Random random = new Random();
        //if its a downtown stop, reduce the next pass event at that stop by 30s
        if(base[stop].equals("Union Depot") || base[stop].equals("Minnesota Street and 4th Street") || base[stop].equals("Cedar Street and 5th Street")){
            BusSim.agenda.add(new PassengerEvent(stop),times[random.nextInt(100)]-30);
        }
        else{BusSim.agenda.add(new PassengerEvent(stop),times[random.nextInt(100)]);} //just set a new inter arrival time from the 100 long list
        Passenger passenger = new Passenger(base[stop]); //make a new passenger at the current stop this pass event is creating people
        PeopleInQueue.enter(passenger); // put them into a queue

    }
    public PassengerEvent(){ //never used

    }
    public PassengerEvent(int place){ //to designate what stop the pass event is making people for
        stop = place;
    }

}
