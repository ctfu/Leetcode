public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int[] res = new int[ratings.length];
        for(int i = 0; i < res.length; i++){    /* all people initially get 1 candy */
            res[i] = 1;
        }
        for(int i = 1; i < ratings.length; i++){    /* satisfy the front neighbor condition based on rating */
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }
        }
        /* necessary to walk backword in such case rating:
         * [2, 3, 2, 1]: init candy: [1, 1, 1, 1] ->(forward) [1, 2, 1, 1] -> (backward)[1,3,2,1]
         * [1, 2, 1, 1] (index 2 doesn't satisfy back neighbor condition) */
        for(int i = ratings.length-1; i > 0; i--){  /* satisfy the back neighbor condition base on rating */
            if(ratings[i-1] > ratings[i]){
                res[i-1] = Math.max(res[i-1], res[i] + 1);
            }
        }
        int candy = 0;
        for(int i = 0; i < res.length; i++){
            candy += res[i];
        }
        return candy;
    }
}
