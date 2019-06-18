/**
 * Created by xain on 11/20/2016.
 */
public class BusStops {


    private Q2 east = new Q2();
    private Q2 west = new Q2();

    public void add(Passenger p, String direction) {
        if (direction.equals("east")) { //adding to correct queue
            east.add(p);
            Stat.updateMaxQEastLength(east.length()); //updating queue lengthhhhhhhhhhhhhh
        } else {
            west.add(p);
            Stat.updateMaxQWestLength(west.length());
        }
    }

    public int eastLength() {
        return east.length();
    }

    public int westLength() {
        return west.length();
    }
    public Q2 getEast() {
        return east;
    }

    public Q2 getWest() {
        return west;
    }

}
