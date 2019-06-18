/**
 * Created by xain on 11/20/2016.
 */
public class Stat {
    //                                  ***********************DO SOME MORE THINGS HERE FOR STAT COLLECTION*************************
    //                                  ****************ALSO SEE IF THE ONES I MADE ARE CORRECT********************


    // public methods
    public static void updatePeopleOnBus() {

    }
    public static void updateMaxQWestLength(int len){
        if(len>maxQWestLength){
            maxQWestLength = len;
        }
    }
    public static void updateMaxQEastLength(int len){
        if(len>maxQEastLength){
            maxQEastLength = len;
        }
    }
    public static void updatePassengerTimeStats(double onbus, double  inline, double exitedbus){
        if(onbus-inline >maxPersonWaitTime){
            maxPersonWaitTime = onbus-inline;
        }
        totalWaitTime += onbus-inline;
        totalTravelTime += exitedbus - onbus;
    }
    public static void updateWestQueueStats(double time, int qlen) {

        if (qlen > maxQWestLength) {
            maxQWestLength = qlen;
        }
        averageQWestLength += oldQWestLength * (time - lastQWestUpdateTime);
        totalWestTime += time - lastQWestUpdateTime;
        lastQWestUpdateTime = time;
        oldQWestLength = qlen;
    }

    public static void updateEastQueueStats(double time, int qlen) {

        if (qlen > maxQEastLength) {
            maxQEastLength = qlen;
        }
        averageQEastLength += oldQEastLength * (time - lastQEastUpdateTime);
        totalEastTime += time - lastQEastUpdateTime;
        lastQEastUpdateTime = time;
        oldQEastLength = qlen;
    }

    public static void updateBusyTimeStats(double time) {

        busyTime += time - lastUpdateTime;
        lastUpdateTime = time;
    }

    public static void updateIdleTimeStats(double time) {

        idleTime += time - lastUpdateTime;
        lastUpdateTime = time;
    }

    public static void updateServiceTimeStats(double st) {

        averageServiceTime += st;
    }

    public static void updateaveragepeopleonelevator(int peopleinele) {
        peopleonelevator += peopleinele;
    }

    public static void updatefloor() {
        numberoffloors++;
    }

    public static void updateBusCount(int passengers) {
        numberofpeopledestination += passengers;
    }

    public static void updateNumberOfPeopleInLine(int people) {
        numberofpeople += people;
    }
    public static void updateNumberOfPeopleGotOnBus(int people){
        numberofpeopleontobus += people;
    }

    public static void updateWaitTimeStats(double time, double enterTime) {

        double wait = time - enterTime;
        if (wait > maxWait)
            maxWait = wait;
        averageWait += wait;
        count++;  // another leaves the waiting queue
    }

    public static void displayStats() {
        System.out.println("\n** Simulation Results **\n");
        System.out.println(" Calculated Simulation Time: " + totalWestTime + totalEastTime);
        //System.out.println(" Idle Time: " + idleTime);
        //System.out.println(" Busy Time: " + busyTime);
        //System.out.println(" (Busy Time based on service time: " +
        //        averageServiceTime + ")\n");
        System.out.println(" Maximum East Queue Length: " + maxQEastLength);
        System.out.println(" Maximum West Queue Length: " + maxQWestLength);

        System.out.println(" Avg. East Queue Length: " + averageQEastLength / totalEastTime);
        System.out.println(" Avg. West Queue Length: " + averageQWestLength / totalWestTime);
        //System.out.println(" Maximum Waiting Time: " + maxWait);
        //System.out.println(" Avg. Waiting Time for cars through the queue: " +
        //       averageWait / count);
        //System.out.println(" Avg. Service Time: " + averageServiceTime /
        //        count);
        System.out.println(" Number of people in line: " + numberofpeople);
        System.out.println("Number of people to destination: " + numberofpeopledestination);
        //System.out.println("Average people on the elevator: "+ peopleonelevator/numberoffloors);
        System.out.println("Max Wait time: " + maxPersonWaitTime);
        System.out.println("Average Wait Time: " + totalWaitTime/numberofpeopleontobus);
        System.out.println("Average Travel Time: " + totalTravelTime/numberofpeopledestination);
        System.out.println("\n");

    }  // displayStats

    // private variables

    private static double lastUpdateTime;
    private static int oldQEastLength;
    private static int oldQWestLength;
    private static double lastQEastUpdateTime;
    private static double lastQWestUpdateTime;
    private static double maxPersonWaitTime;
    private static int count;
    private static double totalWaitTime;
    private static double totalTravelTime;
    private static double totalEastTime;
    private static double totalWestTime;
    private static double busyTime;
    private static double idleTime;
    private static double maxWait;
    private static double averageWait;
    private static int maxQEastLength;
    private static int maxQWestLength;
    private static double averageQEastLength;
    private static double averageQWestLength;
    private static double averageServiceTime;
    private static int numberofpeople = 0;
    private static int numberofpeopledestination = 0;
    private static double peopleonelevator = 0;
    private static double numberoffloors = 0;
    private static double numberofpeopleontobus;
}
