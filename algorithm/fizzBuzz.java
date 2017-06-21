public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String mul3 = "Fizz";
        String mul5 = "Buzz";
        String mul35 = "FizzBuzz";
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                res.add(mul35);
            }else if(i % 3 == 0){
                res.add(mul3);
            }else if (i % 5 == 0){
                res.add(mul5);
            }else{
                res.add(i + "");
            }
        }
        return res;
    }
}
