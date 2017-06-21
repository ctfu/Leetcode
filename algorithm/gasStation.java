/* For example the circular station below
1->2-3
|    |
6<-5-4
* Couple points to note:
* 1. if Station A cant reach to B, any station between A~B cant reach to B
* Example: if station(1) cant reach station(4), and 4 is the first unreachable station from 1
* (gas(1)-cos(1))+(gas(2)-cos(2))+(gas(3)-cos(3)) < 0
* Prove station(2), station(3) cant reach to 4:
* since station(1) can reach to station(3), so gas(1)-cos(1) > 0 && gas(2)-cos(2) > 0
* gas needed startng from station 2: gas(2)-cos(2) + gas(3)-cos(3) < 0 - (gas(1)-cos(1)) < 0
* gas needed startng from station 3: gas(3)-cos(3) < 0 - (gas(1)-cos(1))-(gas(2)-cos(2)) < 0
* 2. The question guaranttee the solution to be unique (only one solution), so start = i+1 is the right start
* Example: if station 1 cant reach to 4, and the start = 5
* since start is 5, which means start can reach to 6, otherwise start will be startng from 6
* if 6 can complete a circle, then 5 must also can complete the circle (contradiction with unqiue solution) */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int tank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i]-cost[i]; /* if cannot reach station i */
            if(tank < 0){
                start = i+1;
                tank = 0; /* reset tank = 0 */
            }
        }
        if(sumGas < sumCost){   /* if there exist a solution */
            return -1;
        }else{
            return start;
        }
    }
}
