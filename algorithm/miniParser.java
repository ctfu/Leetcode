/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*  Approach: stack */
public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                start = i + 1;
            } else if (c == ',') {
                if (i > start) {
                    String num = s.substring(start, i);
                    cur.add(new NestedInteger(Integer.parseInt(num)));
                }
                start = i + 1;
            } else if (c == ']') {
                String num = s.substring(start, i);
                if (!num.isEmpty()) {
                    cur.add(new NestedInteger(Integer.parseInt(num)));
                }
                if (!stack.empty()) {
                    NestedInteger temp = stack.pop();
                    temp.add(cur);
                    cur = temp;
                }
                start = i + 1;
            }
        }
        return cur;

    }
}
