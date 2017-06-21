/* Method 1, time complexity: O(nlogn) */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if(tickets.length == 0 || tickets[0].length == 0) return res;
        Arrays.sort(tickets, (ticket1, ticket2) -> ticket1[1].compareTo(ticket2[1]));
        Set<String[]> visited = new HashSet<>();
        for(String[] ticket : tickets){
            if(ticket[0].equals("JFK") && !visited.contains(ticket)){
                visited.add(ticket);
                res.add(ticket[0]);
                res.add(ticket[1]);
                findRoute(res, tickets, ticket[1], visited);
                if(tickets.length != visited.size()){
                    res.clear();
                    visited.clear();
                }
            }
        }
        return res;
    }
    private void findRoute(List<String> res, String[][] tickets, String source, Set<String[]> visited){
        for(String[] ticket : tickets){
            if(!visited.contains(ticket) && ticket[0].equals(source)){
                visited.add(ticket);
                res.add(ticket[1]);
                findRoute(res, tickets, ticket[1], visited);
                if(visited.size() != tickets.length){
                    visited.remove(ticket);
                    res.remove(res.size()-1);
                }
            }
        }
    }
}

/* Method 2, time complexity: O(n)*/
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if(tickets == null || tickets.length == 0) return res;

        Map<String, PriorityQueue<String>> hm = new HashMap<>();
        for(String[] ticket : tickets){
            if(!hm.containsKey(ticket[0])){
                hm.put(ticket[0], new PriorityQueue<String>());
            }
            hm.get(ticket[0]).offer(ticket[1]);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.empty()){
            String src = stack.peek();
            if(hm.containsKey(src) && !hm.get(src).isEmpty()){
                stack.push(hm.get(src).poll());
            }else{
                res.add(0, stack.pop());
            }
        }
        return res;
    }
}
