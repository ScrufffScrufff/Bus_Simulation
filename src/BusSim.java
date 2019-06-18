/**
 * Created by xain on 11/20/2016.
 */
public class BusSim {
    public static PQ agenda = new PQ();

    public static void main(String[] args) {
        //18 max buses
        Bus bus = new Bus();
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Bus bus3 = new Bus();
        Bus bus4 = new Bus();
        Bus bus5 = new Bus();
        Bus bus6 = new Bus();
        Bus bus7 = new Bus();
        Bus bus8 = new Bus();
        Bus bus9 = new Bus();
        Bus bus10 = new Bus();
        Bus bus11 = new Bus();
        Bus bus12 = new Bus();
        Bus bus13 = new Bus();
        Bus bus14 = new Bus();
        Bus bus15 = new Bus();
        Bus bus16 = new Bus();
        Bus bus17 = new Bus();
        agenda.add(new BusEvent(bus,"University Ave and 27th Street SE",0),0);
        agenda.add(new BusEvent(bus1,"University Ave and 27th Street SE",0),180);
        agenda.add(new BusEvent(bus2,"University Ave and 27th Street SE",0),360);
        agenda.add(new BusEvent(bus3,"University Ave and 27th Street SE",0),540);
        agenda.add(new BusEvent(bus4,"University Ave and 27th Street SE",0),720);
        agenda.add(new BusEvent(bus5,"University Ave and 27th Street SE",0),900);
        agenda.add(new BusEvent(bus6,"University Ave and 27th Street SE",0),1080);
        agenda.add(new BusEvent(bus7,"University Ave and 27th Street SE",0),1260);
        agenda.add(new BusEvent(bus8,"University Ave and 27th Street SE",0),1440);
        agenda.add(new BusEvent(bus9,"University Ave and 27th Street SE",0),1620);
        agenda.add(new BusEvent(bus10,"University Ave and 27th Street SE",0),1620+180);
        agenda.add(new BusEvent(bus11,"University Ave and 27th Street SE",0),1620+360);
        agenda.add(new BusEvent(bus12,"University Ave and 27th Street SE",0),1620+540);
        agenda.add(new BusEvent(bus13,"University Ave and 27th Street SE",0),1620+720);
        agenda.add(new BusEvent(bus14,"University Ave and 27th Street SE",0),1620+900);
        agenda.add(new BusEvent(bus15,"University Ave and 27th Street SE",0),1620+1080);
        agenda.add(new BusEvent(bus16,"University Ave and 27th Street SE",0),1620+1260);
        agenda.add(new BusEvent(bus17,"University Ave and 27th Street SE",0),1620+1440);
        // one pass event for each stop
        agenda.add(new PassengerEvent(0),0);
        agenda.add(new PassengerEvent(1),0);
        agenda.add(new PassengerEvent(2),0);
        agenda.add(new PassengerEvent(3),0);
        agenda.add(new PassengerEvent(4),0);
        agenda.add(new PassengerEvent(5),0);
        agenda.add(new PassengerEvent(6),0);
        agenda.add(new PassengerEvent(7),0);
        agenda.add(new PassengerEvent(8),0);
        agenda.add(new PassengerEvent(9),0);
        while (agenda.getCurrentTime() <= 28800){ //8 hr work day; EVEN WITH MAX SIZE ON BUSES AND MAX BUSES SHIT STILL AINT IN EQUALIBRIUM WTFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
            agenda.remove().run();
        }
        Stat.displayStats();
        // queues and their size at the end of the sim
        System.out.println("**Display Queues at end of run**");
        System.out.println("East: " + PeopleInQueue.twentyseventh.getEast().length() + " West: " + PeopleInQueue.twentyseventh.getWest().length());
        System.out.println("East: " + PeopleInQueue.raymond.getEast().length() + " West: " + PeopleInQueue.raymond.getWest().length());
        System.out.println("East: " + PeopleInQueue.fairview.getEast().length() + " West: " + PeopleInQueue.fairview.getWest().length());
        System.out.println("East: " + PeopleInQueue.snelling.getEast().length() + " West: " + PeopleInQueue.snelling.getWest().length());
        System.out.println("East: " + PeopleInQueue.lexington.getEast().length() + " West: " + PeopleInQueue.lexington.getWest().length());
        System.out.println("East: " + PeopleInQueue.dale.getEast().length() + " West: " + PeopleInQueue.dale.getWest().length());
        System.out.println("East: " + PeopleInQueue.marion.getEast().length() + " West: " + PeopleInQueue.marion.getWest().length());
        System.out.println("East: " + PeopleInQueue.cedar.getEast().length() + " West: " + PeopleInQueue.cedar.getWest().length());
        System.out.println("East: " + PeopleInQueue.minnesota.getEast().length() + " West: " + PeopleInQueue.minnesota.getWest().length());
        System.out.println("East: " + PeopleInQueue.union.getEast().length() + " West: " + PeopleInQueue.union.getWest().length());
        System.out.println("The east queues doing down as they get towards the end is the effect of less and less people want to go the fewer and fewer stops; same can be said for the west just flipped. ");

    }
}
