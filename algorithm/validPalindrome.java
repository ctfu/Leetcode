public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        String str = s.toLowerCase();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetterOrDigit(str.charAt(i))){
                sb1.append(str.charAt(i));
            }
        }
        String str1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder(str1);
        String str2 = sb2.reverse().toString();

        return str1.equals(str2);
    }
}

//second solution using regular express
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}

//third solution using two pointers
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int head = 0, tail = s.length() -1;
        while(head <= tail){
            if(!Character.isLetterOrDigit(s.charAt(head))){
                head++;
            }else if (!Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }else{
                if(Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
