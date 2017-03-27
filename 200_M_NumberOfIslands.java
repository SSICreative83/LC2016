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
    
    // more consice DFS solution
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            } 
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}



//Union Find solution
class UnionFind { 

    private int[] father = null;
    private int count;

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public UnionFind(int n) {
        // initialize your data structure here.
        father = new int[n];
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count --;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
    
    public void set_count(int total) {
        count = total;
    }
}

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0)
            return 0;
        int m = grid[0].length;
        if (m == 0)
            return 0;
        UnionFind union_find = new UnionFind(n * m);
        
        int total = 0;
        for(int i = 0;i < grid.length; ++i)
            for(int j = 0;j < grid[0].length; ++j)
            if (grid[i][j])
                total ++;
    
        union_find.set_count(total);
        for(int i = 0;i < grid.length; ++i)
            for(int j = 0;j < grid[0].length; ++j)
            if (grid[i][j]) {
                if (i > 0 && grid[i - 1][j]) {
                    union_find.connect(i * m + j, (i - 1) * m + j);
                }
                if (i <  n - 1 && grid[i + 1][j]) {
                    union_find.connect(i * m + j, (i + 1) * m + j);
                }
                if (j > 0 && grid[i][j - 1]) {
                    union_find.connect(i * m + j, i * m + j - 1);
                }
                if (j < m - 1 && grid[i][j + 1]) {
                    union_find.connect(i * m + j, i * m + j + 1);
                }
            }
        return union_find.query();
    }
}
