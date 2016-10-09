/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() <= 1)  return intervals;
        
        Collections.sort(intervals, new intervalComp());
        
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval pre = res.get(res.size() - 1);
            Interval cur = intervals.get(i);
            
            if(pre.end >= cur.start) {
                Interval newInt = new Interval(pre.start, Math.max(pre.end, cur.end));
                res.remove(res.size() - 1);
                res.add(newInt);
            } else {
                res.add(cur);
            }
        }
        
        return res;
    }
    
    
}

class intervalComp implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        if(a.start < b.start)   return -1;
        else if(a.start > b.start)  return 1;
        else    return 0;
    }
}
