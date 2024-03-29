/**
 * Created by xain on 11/18/2016.
 */
public class Segment {

    private double time;
    private Q2 q;
    private Segment next;

    // constructor

    public Segment(double t) {
        time = t;
        q = new Q2();
        next = null;
    }

    // methods

    public double getTime() {
        return time;
    }

    public Q2 getEvents() {
        return q;
    }

    public Segment getNext() {
        return next;
    }

    public void setNext(Segment nextSegment) {
        next = nextSegment;
    }

}
