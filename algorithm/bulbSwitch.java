/*
There are n bulbs that are initially off. You first turn on all the bulbs. Then,
you turn off every second bulb. On the third round, you toggle every third bulb
(turning on if it's off or turning off if it's on). For the i-th round, you toggle
every i bulb. For the n-th round, you only toggle the last bulb. Find how many
bulbs are on after n rounds.

Example:

Input: 3
Output: 1
Explanation:
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].

So you should return 1, because there is only one bulb is on.
*/
/*
1. a bulb is on iff it was switched odd number of times
2. a bulb (index i) is switched iff the bulb index can be divided evenly by round (index r)
which indicates that a bulb is on iff its has odd number of divisors
3. divisors comes in pars, only square number has odd divisors
4. the answer is to count how many square number between 1 ... n (sqrt(n))
*/
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
