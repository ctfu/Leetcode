public class Solution {
    public List<Integer> getRow(int rowIndex) { //the index is starting from 0
        List<Integer> list = new ArrayList<Integer>();
    	if (rowIndex < 0)
    		return list;

    	for (int i = 0; i < rowIndex + 1; i++) {
    		list.add(0, 1);//added to the front each time
    		for (int j = 1; j < list.size() - 1; j++) {
    			list.set(j, list.get(j) + list.get(j + 1));
    		}
    	}
    	return list;
        }
}
