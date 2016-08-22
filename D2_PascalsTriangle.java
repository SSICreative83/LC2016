public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(list1);
        if(numRows == 1) return res;
        
        List<Integer> last = new ArrayList<>();
        for(int i = 1; i < numRows; i++) {
            List<Integer> listi = new ArrayList<>();
            listi.add(1);
            
            last = res.get(i - 1);
            for(int j = 1; j < i; j++) {    //Need to use i as boundry
                listi.add(j, last.get(j - 1) + last.get(j));
            }
            
            listi.add(1);
            res.add(listi);
        }
        
        return res;
    }
}
