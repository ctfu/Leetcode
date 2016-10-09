public class Solution {
    public int romanToInt(String s) {
      if(s.length() < 0) return 0;

      int pre = charToInt(s.charAt(0));
      int sum = pre;
      for(int i = 1; i < s.length(); i++){
          int cur = charToInt(s.charAt(i));
          sum += cur;
          if(pre < cur) sum -= 2 * pre; //added twice
          pre = cur;
      }
      return sum;
    }

      //convert roman char to intege
    private int charToInt(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}
