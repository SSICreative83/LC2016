public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0) {
            return 0;
        }
        
        Map<Integer, Integer> point = new HashMap<>();
        int len = 0;
        for(List<Integer> line : wall) {
            int cursum = 0;
            for(int i : line) {
                cursum += i;
                if(point.containsKey(cursum)) {
                    point.put(cursum, point.get(cursum) + 1);
                } else {
                    point.put(cursum, 1);
                }
            }
            len = cursum;
        }
        point.remove(len);  //delete last one
        
        int max = 0;
        for(int key : point.keySet()) {
            int cur = point.get(key);
            max = Math.max(max, cur);
        }
        
        return wall.size() - max;
    }
}
