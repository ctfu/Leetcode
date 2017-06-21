public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;

        List<String> digitStr = new ArrayList<>();
        for(char c : digits.toCharArray()){
            digitStr.add(getStr(c));
        }
        StringBuilder sb = new StringBuilder();
        combination(res, sb, digitStr, 0);
        return res;
    }
    private void combination(List<String> res, StringBuilder sb, List<String> digStr, int index){
        if(index == digStr.size()){
            res.add(sb.toString());
        }else{
            String str = digStr.get(index);
            char[] chars = str.toCharArray();
            for(int j = 0; j < chars.length; j++){
                sb.append(chars[j]);
                combination(res, sb, digStr, index + 1);
                sb.setLength(sb.length() -1);
            }
        }
    }
    private String getStr(char c){
        switch(c){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default: return "";
        }
    }
}

/* second solution */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        combination(res, sb, digits, 0, mapping);
        return res;
    }
    private void combination(List<String> res, StringBuilder sb, String digits, int index, String[] mapping){
        if(index == digits.length()){
            res.add(sb.toString());
        }else{
            String str = mapping[digits.charAt(index) - '0'];
            for(int i = 0; i < str.length(); i++){
                sb.append(str.charAt(i));
                combination(res, sb, digits, index+1, mapping);
                sb.setLength(sb.length()-1);
            }
        }
    }
}
