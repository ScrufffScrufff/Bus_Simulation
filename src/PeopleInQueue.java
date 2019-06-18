/**
 * Created by xain on 11/25/2016.
 */
public class PeopleInQueue {
    // queues for each stop
    static BusStops twentyseventh = new BusStops();
    static BusStops raymond = new BusStops();
    static BusStops fairview = new BusStops();
    static BusStops snelling = new BusStops();
    static BusStops lexington = new BusStops();
    static BusStops dale = new BusStops();
    static BusStops marion = new BusStops();
    static BusStops cedar = new BusStops();
    static BusStops minnesota = new BusStops();
    static BusStops union = new BusStops();

    public static void enter(Passenger p){
        p.setLineEntryTime(BusSim.agenda.getCurrentTime()); //updating time at which the person entered the queue
        switch (p.getPickup()){
            case "University Ave and 27th Street SE":
                twentyseventh.add(p,p.getDirection()); //adding people to the correct queue, in the correct direction
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),twentyseventh.westLength()); //trying to update stats based off dovolis' original layout
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),twentyseventh.eastLength());} //samesies
                Stat.updateNumberOfPeopleInLine(1); //updating the number of people in line
                break;
            case "Raymond Ave Station":
                raymond.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),raymond.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),raymond.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "University Ave and Fairview Ave":
                fairview.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),fairview.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),fairview.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "University Ave and Snelling Ave":
                snelling.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),snelling.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),snelling.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "University Ave and Lexington Parkway":
                lexington.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),lexington.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),lexington.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "University Ave and Dale Street":
                dale.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),dale.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),dale.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "University Ave and Marion Street":
                marion.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),marion.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),marion.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "Cedar Street and 5th Street":
                cedar.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),cedar.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),cedar.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "Minnesota Street and 4th Street":
                minnesota.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),minnesota.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),minnesota.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
            case "Union Depot":
                union.add(p,p.getDirection());
                if (p.getDirection().equals("east")) {
                    Stat.updateEastQueueStats(BusSim.agenda.getCurrentTime(),union.westLength());
                }
                else{Stat.updateWestQueueStats(BusSim.agenda.getCurrentTime(),union.eastLength());}
                Stat.updateNumberOfPeopleInLine(1);
                break;
        }
    }
}
