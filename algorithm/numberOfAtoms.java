/* Approach: stack + treeMap */
class Solution {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        int len = formula.length();
        TreeMap<String, Integer> curMap = new TreeMap<>();
        for (int i = 0; i < len;) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(curMap);
                curMap = new TreeMap<>();
                i++;
            } else if (c == ')') {
                TreeMap<String, Integer> temp = curMap;
                curMap = stack.pop();
                i++;
                int istart = i;
                int quantity = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                if (i > istart) {
                    quantity = Integer.parseInt(formula.substring(istart, i));
                }
                for (String name : temp.keySet()) {
                    curMap.put(name, curMap.getOrDefault(name, 0) + temp.get(name) * quantity);
                }
            } else {
                int istart = i;
                i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(istart, i);
                istart = i;
                while (i < len && Character.isDigit(formula.charAt(i))) i++;
                int quantity = 1;
                if (i > istart) {
                    quantity = Integer.parseInt(formula.substring(istart, i));
                }
                curMap.put(name, curMap.getOrDefault(name, 0) + quantity);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String name : curMap.keySet()) {
            int quantity = curMap.get(name);
            sb.append(name);
            if (quantity > 1) {
                sb.append(quantity);
            }
        }
        return sb.toString();
    }
}
