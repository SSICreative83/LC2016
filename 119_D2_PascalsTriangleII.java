public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        
        res.add(1);
        if(rowIndex == 0) return res;
        
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> last = res;
            res = new ArrayList<>();
            res.add(1);
            for(int j = 1; j < i; j++) {
                res.add(j, last.get(j - 1) + last.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
