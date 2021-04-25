package ratelimiter;

import org.junit.Assert;

import java.time.Instant;
import java.util.*;

public class RateLimiter {

    /**
     * Device Hash key
     */
    private int deviceIdOrUserKey;

    /**
     * Total request handled currently
     */
    private int totalCount;

    /**
     * Handles sliding window storage
     */
    LinkedList<PeriodicRequestData> slidingWindowStorage = new LinkedList<>();

    /**
     * Time frame you can use
     */
    private final TimeFrame timeFrame;

    public enum TimeFrame {
        SECONDS,
        MINUTE,
        HOUR,
        DAYS
    }

    /**
     * Maximum no of request accepted in provided time frame
     */
    final int maxNoOfRequest;

    /**
     * Size of TimeFrame window ex. 3 Request per 10 Seconds. This is will contain 10 seconds.
     */
    private final long time;

    /*
    Constructor
     */
    public RateLimiter(int maxRequest, long time, TimeFrame timeFrame) {
        this.maxNoOfRequest = maxRequest;
        this.timeFrame = timeFrame;
        this.time = time;
    }

    /**
     * Static class holding timeStamp and no of request
     */
    static class PeriodicRequestData {

        private final long timestamp;

        private final long noOfRequest;

        public PeriodicRequestData(long timestamp, long noOfRequest) {
            this.timestamp = timestamp;
            this.noOfRequest = noOfRequest;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getNoOfRequest() {
            return noOfRequest;
        }

        public String toString() {
            return timestamp+":"+noOfRequest;
        }
    }

    /**
     * This method validate whether we can add the request or not. If we can add it will add the same in sliding window.
     *
     * @param noOfRequest   No of request at any point of time.
     * @throws Exception    Throws exception if partial no of request or all request are not accepted.
     */
    public void validateRequestAndAdd(int noOfRequest) throws Exception {
        System.out.println("Request quantity:"+noOfRequest+", Total request holding:"+totalCount+", Max Request:"+maxNoOfRequest);
        int noOfRequestCanBeAccommodated = validateThatRequestCanBeAccommodated();

        if (noOfRequestCanBeAccommodated >= noOfRequest) {
            slidingWindowStorage.add(new PeriodicRequestData(Instant.now().getEpochSecond(), noOfRequest));
            totalCount = totalCount + noOfRequest;
        }
        else if(noOfRequestCanBeAccommodated > 0) {
            slidingWindowStorage.add(new PeriodicRequestData(Instant.now().getEpochSecond(), noOfRequestCanBeAccommodated));
            totalCount = totalCount + noOfRequestCanBeAccommodated;
            System.out.println("Only fewer request are accepted: "+noOfRequestCanBeAccommodated);
            throw new Exception("[WARN] Only fewer request are accepted: "+noOfRequestCanBeAccommodated);
        }
        else {
            throw new Exception("Request cannot be processed");
        }
    }

    /**
     * Validate whether sliding window have capacity to add more request or not.
     *
     * @return  Amount of request can be accepted at any point of time.
     */
    public int validateThatRequestCanBeAccommodated()  {
        long currentTime = Instant.now().getEpochSecond();
        switch (timeFrame) {
            case SECONDS:
                System.out.println("Sliding window storage: "+slidingWindowStorage);
                int length_1 = slidingWindowStorage.size();
                for (int i=0;i<length_1;i++) {
                    PeriodicRequestData periodicRequestData = slidingWindowStorage.getFirst();
                    if(currentTime - periodicRequestData.getTimestamp() >= time) {
                        totalCount -= periodicRequestData.getNoOfRequest();
                        slidingWindowStorage.removeFirst();
                    }
                    else {
                        break;
                    }
                }
                System.out.println("Sliding window storage after processing: "+slidingWindowStorage);
                return maxNoOfRequest - totalCount;
            case MINUTE:
                System.out.println("Sliding window storage: "+slidingWindowStorage);
                int length_2 = slidingWindowStorage.size();
                for (int i=0;i<length_2;i++) {
                    PeriodicRequestData periodicRequestData = slidingWindowStorage.getFirst();
                    long minutes = Math.floorDiv(currentTime - periodicRequestData.getTimestamp(),60);
                    if(minutes >= time) {
                        totalCount -= periodicRequestData.getNoOfRequest();
                        slidingWindowStorage.removeFirst();
                    }
                    else {
                        break;
                    }
                }
                System.out.println("Sliding window storage after processing: "+slidingWindowStorage);
                return maxNoOfRequest - totalCount;
            case HOUR:
                System.out.println("Sliding window storage: "+slidingWindowStorage);
                int length_3 = slidingWindowStorage.size();
                for (int i=0;i<length_3;i++) {
                    PeriodicRequestData periodicRequestData = slidingWindowStorage.getFirst();
                    long minutes = Math.floorDiv(currentTime - periodicRequestData.getTimestamp(),3600);
                    if(minutes >= time) {
                        totalCount -= periodicRequestData.getNoOfRequest();
                        slidingWindowStorage.removeFirst();
                    }
                    else {
                        break;
                    }
                }
                System.out.println("Sliding window storage after processing: "+slidingWindowStorage);
                return maxNoOfRequest - totalCount;
        }

        return 0;
    }

    /*
    Starter class
     */
    public static void main(String[] args) throws Exception {
        //5 request per 20 second
        System.out.println("Test case 1");
        RateLimiter rateLimiter = new RateLimiter(5, 20, TimeFrame.SECONDS);
        rateLimiter.validateRequestAndAdd(2);
        Thread.sleep(2000);
        rateLimiter.validateRequestAndAdd(2);
        Assert.assertThrows(Exception.class, () -> rateLimiter.validateRequestAndAdd(2));
        // Scenario to wait for sometime
        //5 Request for 10 seconds
        System.out.println("Test case 2");
        RateLimiter rateLimiter_1 = new RateLimiter(5, 10, TimeFrame.SECONDS);
        rateLimiter_1.validateRequestAndAdd(2);
        Thread.sleep(2000);
        rateLimiter_1.validateRequestAndAdd(2);
        Thread.sleep(10000);
        rateLimiter_1.validateRequestAndAdd(2);
        Assert.assertThrows(Exception.class, () -> rateLimiter.validateRequestAndAdd(10));

        System.out.println("Test case 3");
        RateLimiter rateLimiter_2 = new RateLimiter(5, 1, TimeFrame.MINUTE);
        rateLimiter_2.validateRequestAndAdd(4);
        rateLimiter_2.validateRequestAndAdd(1);
        Assert.assertThrows(Exception.class, () -> rateLimiter_2.validateRequestAndAdd(2));

        System.out.println("Test case 4");
        RateLimiter rateLimiter_3 = new RateLimiter(5, 1, TimeFrame.MINUTE);
        rateLimiter_3.validateRequestAndAdd(4);
        rateLimiter_3.validateRequestAndAdd(1);
        Thread.sleep(60000);
        //This request will be accepted since 1 minute window is expired.
        rateLimiter_3.validateRequestAndAdd(2);
    }
}
