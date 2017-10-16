class Solution {
    public String nextClosestTime(String time) {
        if(time == null || time.length() == 0) {
            return "";
        }
        // using a tree set to get the next bigger digit than the current digit
        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':') {
                treeSet.add(time.charAt(i));
            }
        }
        char[] timeStr = time.toCharArray();
        // loop through the digit starting from end
        for (int i = timeStr.length - 1; i >= 0; i--) {
            char origin = timeStr[i];
            Character c = treeSet.higher(timeStr[i]);
            System.out.println(c);
            if (c != null) {
                timeStr[i] = c;
                String closest = new String(timeStr);
                int hour = Integer.parseInt(closest.substring(0, closest.indexOf(":")));
                int minute = Integer.parseInt(closest.substring(closest.indexOf(":") + 1, closest.length()));
                if (hour <= 23 && minute <= 59) {
                    timeStr = closest.toCharArray();
                    // if change is valid, set all digits after current position to the smallest digit
                    for (int j = i + 1;  j < timeStr.length; j++) {
                        if (timeStr[j] != ':') {
                            timeStr[j] = treeSet.first();
                        }
                    }
                    return new String(timeStr);
                }
                timeStr[i] = origin; // if not valid, restroe back
            }
        }
        char c = treeSet.first();
        return "" + c + c + ":" + c + c; // important for the leading "", for c + c is an integer operation
    }
}

/* approach two
* simulate the clock running by adding 1 minute to the total time represented as 24 * 60
*/
class Solution {
    public String nextClosestTime(String time) {
        if(time == null || time.length() == 0) {
            return "";
        }
        // represent the time in a 24 * 60 format
        int totalTime = 60 * Integer.parseInt(time.substring(0, 2));
        totalTime += Integer.parseInt(time.substring(3));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':') {
                set.add(time.charAt(i) - '0');
            }
        }
        while (true) {
            boolean flag = true;
            // add one minute to and see if the new time contains all the valid digits
            totalTime = (totalTime + 1) % (24 * 60);
            int[] digits = new int[] {totalTime / 60 / 10, totalTime / 60 % 10, totalTime % 60 / 10, totalTime % 60 % 10};
            for (int d : digits) {
                if (!set.contains(d)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return String.format("%02d:%02d", totalTime / 60, totalTime % 60);//string formating
            }
        }
    }
}
