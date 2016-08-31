public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        if(rows == 0)   return 0;
        int cols = obstacleGrid[0].length;
        if(cols == 0)   return 0;
        
        int[][] res = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else if(i == 0 && j == 0) {
                    res[i][j] = 1;
                }else if(i == 0) {
                    res[i][j] = res[i][j - 1];
                } else if(j == 0) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[rows - 1][cols - 1];
    }
}
