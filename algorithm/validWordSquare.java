/* A feature of word sequare: words.get(i).charAt(j) == words.get(j).charAt(i)
a valid wordSquare look as below
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
*/
public class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) return true;
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.get(i).length(); j++){
                /* j >= words.size(): check if a word length in i's row is longer
                 * i >= words.get(j).length(): check if a word in i's column is longer
                 * words.get(i).charAt(j) != words.get(j).charAt(i): valid word square checking
                 * Note: should test last one at last to avoid index out of bound */
                if(j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
