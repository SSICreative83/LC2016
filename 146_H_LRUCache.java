class Node{
    Node pre;
    Node next;
    int key;
    int value;
    Node(int k, int v){
        this.key = k;
        this.value = v;
        this.pre = null;
        this.next = null;
    }
}

public class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node front = new Node(-1, -1);
    Node end = new Node(-1, -1);
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
        front.next = end;
        end.pre = front;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        move(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){ 
            map.get(key).value = value;
            return;
        }
        if(map.size() == cap){
            map.remove(front.next.key);
            front.next = front.next.next;
            front.next.pre = front;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        move(node);
    }
    
    private void move(Node node){ //move input node to end
        node.pre = end.pre;
        node.pre.next = node;
        node.next = end;
        end.pre = node;
    }
}
