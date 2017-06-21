public class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        for(int i = 2; i < n; i++){ /* start from 2 becasue 1 is not prime */
            primes[i] = true;
        }
        for(int k = 2; k <= n/k; k++){
            if(primes[k]){
                for(int i = k; i <= n/k; i++){
                    primes[k * i] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < primes.length; i++){
            if(primes[i] == true){
                count++;
            }
        }
        return count;
    }
}
