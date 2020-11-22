class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        //A[i]*B[i]
        int m = nums1.length;
        int n = nums2.length;
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if(i > 0 && j > 0 && dp[i - 1][j - 1] > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if(i > 0 && dp[i - 1][j] > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j];
                }
                if(j > 0 && dp[i][j - 1] > dp[i][j]) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];           
    }
}