public class MovingAverage {

    Queue<Integer> pq;
    int curSize;
    int cap;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        pq = new LinkedList<>();
        curSize = 0;
        cap = size;
    }
    
    public double next(int val) {
        pq.add(val);
        if(curSize < cap) {
            curSize++;
        } else {
            pq.remove();
        }
        double sum = 0;
        for(int i : pq) {
            sum += i;
        }
        
        return sum / curSize;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
