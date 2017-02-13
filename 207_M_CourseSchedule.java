public class Solution {
    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) return true;
        
        ArrayList[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int courseNum = prerequisites[i][0];
            int preNum = prerequisites[i][1];
            graph[courseNum].add(preNum);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(ArrayList[] graph, boolean[] visited, int courseNum) {
        if(visited[courseNum]) {
            return false;   
        } else {
            visited[courseNum] = true;
        }
        
        ArrayList pres = graph[courseNum];
        for(int i = 0; i < pres.size(); i++) {
            int pre = (int) pres.get(i);
            if(!dfs(graph, visited, pre)) {
                return false;
            }
        }
        visited[courseNum] = false;
        return true;
    }
}
