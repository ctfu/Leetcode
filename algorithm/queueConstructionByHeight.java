/*
1. Pick out tallest group of people and sort them in a subarray (S).
  Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
2. For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
*/
public class Solution {
    /* two diamention array is consider as a list of list */
    public int[][] reconstructQueue(int[][] people) {
      /* if same h, sort it asending order with k, if diffrent h, sort in desending order with h */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> res = new LinkedList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}

/* comparator without using lambda expression */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]; /* important step */
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]); /* important step */
    }
}
