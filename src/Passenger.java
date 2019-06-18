import java.util.Random;

/**
 * Created by xain on 11/18/2016.
 */
public class Passenger {
    private String pickup, dropoff, direction;
    private double time;
    private double bustime,exitBusTime;
    private String[] p = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street", "Minnesota Street and 4th Street", "Union Depot", "Union Depot"};
    private String[] base = new String[]{"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave", "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street", "Cedar Street and 5th Street", "Minnesota Street and 4th Street","Union Depot"};


    Passenger(String pickup) {
        //time = BusSim.agenda.getCurrentTime();
        int j=0;
        int picktemp = 0 ,droptemp = 0;
        this.pickup = pickup;
        Random random = new Random();
        dropoff = p[random.nextInt(13)]; //make a dropoff place for him
        while (dropoff.equals(pickup)) { // while dropoff == pickup find a new dropoff
            dropoff = p[random.nextInt(13)];
        }
        for(int i = 0; i < base.length;i++){
            if(base[i].equals(pickup)){
                picktemp = i;  //getting numerical values for where they are on the route
            }
            if(base[j].equals(dropoff)){
                droptemp = j; // getting numerical values for where they are ob the route
            }
            j++;
        }
        if(picktemp>droptemp){
            direction = "west";
        }
        else{
            direction = "east";
        }

    }

    // need most of these for stats collections
    public String getPickup() {
        return pickup;
    }

    public String getDropoff() {return dropoff;}

    public String getDirection(){return direction;}

    public void setLineEntryTime(double time){
        this.time = time;
    }

    public double getLineEntryTime() {
        return time;
    }

    public void setBusTime(double time){
        bustime = time;
    }
    public double getBusTime(){
        return bustime;
    }
    public void setExitBusTime(double time){
        exitBusTime = time;
    }
    public double getExitBusTime(){
        return exitBusTime;
    }


}
