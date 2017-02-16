//my solution DFS, time limit exceeded, because DFS is doing repeated computing for same cell
public class Solution {    
    int max = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return 0;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(matrix, m, n, i, j, 1);
            }
        }
       
        return max;
    }
    
    public void dfs(int[][] matrix, int rows, int cols, int i, int j, int curLen) {
        if(i < 0 || j < 0 || i >= rows || j >= cols) {
            return;
        }
        
        //up
        if(i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            int nextLen = curLen + 1;
            max = Math.max(max, nextLen);
            dfs(matrix, rows, cols, i - 1, j, nextLen);
        }
        
        //down
        if(i < rows - 1 && matrix[i + 1][j] > matrix[i][j]) {
            int nextLen = curLen + 1;
            max = Math.max(max, nextLen);
            dfs(matrix, rows, cols, i + 1, j, nextLen);
        } 
        
        //left
        if(j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            int nextLen = curLen + 1;
            max = Math.max(max, nextLen);
            dfs(matrix, rows, cols, i, j - 1, nextLen);
        }
        
        //right
        if(j < cols - 1 && matrix[i][j + 1] > matrix[i][j]) {
            int nextLen = curLen + 1;
            max = Math.max(max, nextLen);
            dfs(matrix, rows, cols, i, j + 1, nextLen);
        }        
    }
}

//Discussion solution, use cache[][] to store max length ending in current cell
public class Solution {
public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n];
    int max = 1;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int len = dfs(matrix, i, j, m, n, cache);
            max = Math.max(max, len);
        }
    }   
    return max;
}

public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    if(cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for(int[] dir: dirs) {
        int x = i + dir[0], y = j + dir[1];
        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
        int len = 1 + dfs(matrix, x, y, m, n, cache);
        max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
}
}
