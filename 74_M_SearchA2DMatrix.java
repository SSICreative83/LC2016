public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)  return false;
        int n = matrix[0].length;
        if(n == 0)  return false;
        
        int start = 0;
        int end = m - 1;
        int line = 0;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(matrix[end][0] <= target) {
            line = end;
        } else if(matrix[start][0] <= target) {
            line = start;
        } else {
            return false;
        }
        
        start = 0;
        end = n - 1;
        int col = 0;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(matrix[line][mid] == target) {
                return true;
            } else if(matrix[line][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(matrix[line][start] == target) {
            return true;
        } else if(matrix[line][end] == target) {
            return true;
        } else {
            return false;
        }
        
        
        
    }
}
