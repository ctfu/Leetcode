/* several assumtions of the question:
 * 1. file name is ".extention" format
 * 2. directory doesnot contains "." */
/* several considerations of the question:
 * 1. longest fiel path means the file path has max chars
 * 2. file is contatenated wit "/", this is also count into max chars
 * 3. could have mutilple file paths */
 /* Approach: DP, table[i] indicates the max chars to level i file
  *  table[i] = talbe[i-1] + curLevelFileLength  */
 /* "\n" as new line to indicate file paths, "\t" as tap space to indicate file level */
public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        /* split the file string into multiple paths */
        String[] paths = input.split("\n");
        /* set up a dp table to store the length of differnet file paths, starting from level 1*/
        int[] table = new int[paths.length + 1];
        int longest = 0;
        for(String path : paths){
            /* calculate the file level, if not found, lastIndexOf("\t") return -1 */
            int lev = path.lastIndexOf("\t") + 1; /* level starts from 0, so its actual file level starts from lev+1 */
            table[lev+1] = table[lev] + path.length() - lev + 1; /* add 1 for "/" */
            int curLen = table[lev+1];
            /* check if it is an ending file */
            if(path.contains(".")){
               longest = Math.max(longest, curLen - 1);/* get rid of last "/" */
            }
        }
        return longest;
    }
}
