public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String mul3 = "Fizz";
        String mul5 = "Buzz";
        String mul3n5 = "FizzBuzz";

        int count = 1;
        while(count <= n){
            if(count % 3 == 0){
                if(count % 5 == 0){
                    res.add(mul3n5);
                }else{
                    res.add(mul3);
                }
            }else if(count % 5 == 0){
                res.add(mul5);
            }else{
                res.add(count + "");
            }
            count++;
        }
        return res;
    }
}
