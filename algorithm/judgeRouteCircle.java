/* if there is a circle,
steps for "U" == steps for "D" && steps for "L" == steps for "R"
*/
class Solution {
    public boolean judgeCircle(String moves) {
        moves = moves + " "; // to balance split creating leading empty string
        return moves.split("U").length == moves.split("D").length &&
            moves.split("L").length == moves.split("R").length;
    }
}
