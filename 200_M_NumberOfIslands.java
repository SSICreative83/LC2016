public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0)  return 0;
        int n = grid[0].length;
        if(n == 0)  return 0;
        
        boolean[][] visited = new boolean[m][n];
        return helper(grid, m, n, visited);
    }
    
    public int helper(char[][] grid, int m, int n, boolean[][] visited) {
        int res = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    res++;
                    dfs(grid, m, n, visited, i, j);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] grid, int m, int n, boolean[][] visited, int row, int col) {
        //up
        if(row - 1 >= 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
            visited[row - 1][col] = true;
            dfs(grid, m, n, visited, row - 1, col);
        }
        
        //down
        if(row + 1 < m && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
            visited[row + 1][col] = true;
            dfs(grid, m, n, visited, row + 1, col);           
        }
        
        //left
        if(col - 1 >= 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
            visited[row][col - 1] = true;
            dfs(grid, m, n, visited, row, col - 1);
        }

        //right
        if(col + 1 < n && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
            visited[row][col + 1] = true;
            dfs(grid, m, n, visited, row, col + 1);
        }
        
    }
}
