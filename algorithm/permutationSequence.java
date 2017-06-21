/* Find permutation pattern */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        int accumulate = 1;
        factorial[0] = 1;   /* 0 factorial = 1 */
        for(int i = 1; i <= n; i++){    /* create a factorial lookup */
            accumulate *= i;
            factorial[i] = accumulate;
        }
        /* create the initial factorial */
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i+1);
        }

    /*  if(k > factorial[n]) k = k % factorial[n];  this handles when k is invalid */
        k = k - 1;  /* let k starts from index zero */
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(list.get(index));
            k -= index * factorial[n-i];
            list.remove(index);
        }
        return sb.toString();
    }
}
