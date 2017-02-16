public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len1 = A.length;
        int len2 = B.length;
        
        if((len1 + len2) % 2 == 1) {
            int k = (len1 + len2) / 2 + 1;
            return findK(A, 0, B, 0, k);
        } else {
            int k = (len1 + len2) / 2;
            return ( findK(A, 0, B, 0, k) + findK(A, 0, B, 0, k + 1) ) / 2.0;
        }
    }

    public int findK(int[] A, int A_start, int[] B, int B_start, int k) {
        if(A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if(B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if(k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        
        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_key < B_key) {
            return findK(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findK(A, A_start, B, B_start + k / 2 , k - k / 2);
        }
        
    }
}
