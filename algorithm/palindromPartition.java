/* similar approch to subset or combination problem */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(res, s, new ArrayList<String>(), 0);
        return res;
    }
    public void partition(List<List<String>> res, String s, List<String> tempList, int index){
        if(index == s.length()){ /* if index reaches to the end of string */
            res.add(new ArrayList<String>(tempList));
        }else{
            for(int i = index; i < s.length(); i++){
                if(isPalindrom(s, index, i)){ /* check substring(index, i) padlindrom */
                    tempList.add(s.substring(index, i+1));
                    partition(res, s, tempList, i + 1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    public boolean isPalindrom(String s, int begin, int end){
        /* two pointer to check padlindrom string */
        while(begin < end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
