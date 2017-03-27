
//Using TreeMap

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int n : map.keySet()) {
            int freq = map.get(n);
            if(freqMap.containsKey(freq)) {
                List<Integer> list = freqMap.get(freq);
                list.add(n);
                freqMap.put(freq, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                freqMap.put(freq, list);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(k > res.size()) {
            Map.Entry<Integer, List<Integer>> numbers = freqMap.pollLastEntry();  //pollLastEntry() will remove last entry
            res.addAll(numbers.getValue());
        }
        return res;
    }
}
