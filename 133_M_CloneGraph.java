/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //DFS
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if(node == null)    return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode nodeCopy = DFS(node, map);
        return nodeCopy;
    }
    
    private UndirectedGraphNode DFS1(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            nodeCopy.neighbors.add(DFS(neighbor, map));
        }
        return nodeCopy;
    }
    //self
    private UndirectedGraphNode DFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        if(map.containsKey(node)) {
            newNode = map.get(node);
        } else {
            map.put(node, newNode);
        }
        
        for(UndirectedGraphNode n : node.neighbors) {
            if(map.containsKey(n)) {
                newNode.neighbors.add(map.get(n));
            } else {
                UndirectedGraphNode newNeib = new UndirectedGraphNode(n.label);
                newNode.neighbors.add(newNeib);
                map.put(n, newNeib);
                DFS(n, map);
            }
        }
        
        return newNode;
    }
    
    //BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curCopy = map.get(cur);
            
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    queue.offer(neighbor);
                    map.put(neighbor, neighborCopy);
                    
                    curCopy.neighbors.add(neighborCopy);
                } else {
                    curCopy.neighbors.add(map.get(neighbor)); //don't forget this case
                }
            }
        }
        
        return nodeCopy;
    }
}
