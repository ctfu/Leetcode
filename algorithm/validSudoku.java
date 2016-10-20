public class Solution {
    /* assign unique code to each number */
   /*'4' in row 7 is encoded as "(4)7".
     '4' in column 7 is encoded as "7(4)".
     '4' in the top-right block is encoded as "0(4)2". */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        String code = "";
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    code = "(" + board[i][j] + ")";
                    if(!seen.add(code + i) || !seen.add(j + code) || !seen.add(i/3 + code + j/3)){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}

//another Solution
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
