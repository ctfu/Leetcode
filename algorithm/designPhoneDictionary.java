public class PhoneDirectory {
    private List<Integer> available;    // for geeting available numbers
    private Set<Integer> assigned;      // for checking already assigned numbers
    private int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        available = new ArrayList<>();
        assigned = new HashSet<>();
        // purposely added from big to small, so we can alwasy get the last number from the list 
        for (int i = maxNumbers - 1; i >= 0; i--) {
            available.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (available.size() > 0) {
            int num = available.get(available.size() - 1);
            assigned.add(num);
            available.remove(available.size() - 1);
            return num;
        } else {
            return -1;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }
        return !assigned.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (assigned.contains(number)) {
            assigned.remove(number);
            available.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
