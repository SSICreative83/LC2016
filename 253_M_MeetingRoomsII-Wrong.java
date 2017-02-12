/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return a.time - b.time;
    }
}
class Point {
    int time;
    boolean isStart;
    public Point(int time, boolean isStart) {
        time = time;
        isStart = isStart;
    }
}
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)  return 0;
        List<Point> points = new LinkedList<>();
        
        for(int i = 0; i < intervals.length; i++) {
            Point a = new Point(intervals[i].start, true);
            Point b = new Point(intervals[i].end, false);
            points.add(a);
            points.add(b);
        }
        Collections.sort(points, new PointComparator()); 
        
        int res = 0;
        int ans = 0;
        for(int i = 0; i < points.size(); i++) {
            Point cur = points.get(i);
            if(!cur.isStart) {
                res--;
            } else {
                res++;
            }
            ans = Math.max(res, ans);
        }
        
        return ans;
    }
}
