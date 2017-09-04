/* Note: the string exp in this question such as x+5-3+x does not contain space in between numbers and x*/
class Solution {
    public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
          res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1]/res[0];
    }

    public int[] evaluateExpression(String exp) {
        /* x+5-3+x: spliting result are: x, +5, -3, +x */
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2]; // res[0] store x's coefficient, res[1] the constant
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
        else if (token.equals("-x")) res[0] -= 1;
        else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
        else res[1] += Integer.parseInt(token);
        }
        return res;
    }
}
