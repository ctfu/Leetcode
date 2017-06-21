public class Logger {
    private final static int DURATION = 10;
    private Map<String, Integer> hm;    /* HashMap to store the earliest same message timestamp */
    /** Initialize your data structure here. */
    public Logger() {
        hm = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message)){
            int oldTimestamp = hm.get(message);
            /* if within duration, dont update HashMap, return false */
            if(timestamp-oldTimestamp < DURATION){
                return false;
            }
        }   /* otherwise, update hashmap to the new earliest timestamp */
        hm.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
