/* Note: assume only contain digits, and both string length equal */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] countN = new int[10]; //to count number of digits
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length(); i++){
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s == g){
                bull++;
            }else{
                if(countN[s] < 0) cow++;/* if s has been decrement before in guess */
                if(countN[g] > 0) cow++;/* if g has been increment before in secret */
                countN[s]++;
                countN[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }
}
