public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n < 0)  return res;
        
        for(int i = 0; i < Math.pow(2, n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;   
    }
    
    //Iterative solution 
    // 0, 1 -> 00, 01, 11, 10 -> 000, 001, 011, 010, 110, 111, 101, 100
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0) {
            return res;
        }
        
        for(int i = 1; i <= n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < res.size(); j++) {
                tmp.add(res.get(j));
            }
            for(int j = res.size() - 1; j >= 0; j--) {
                tmp.add((1 << (i - 1)) + res.get(j));
            }
            
            res = tmp;
        }
        return res;
    }
}
