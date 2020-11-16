class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack();
        st.push(Integer.MAX_VALUE);
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i] >= st.peek()) {
                res += st.pop() * Math.min(arr[i], st.peek());
            }
            st.push(arr[i]);
        }
        while(st.size() > 2) {
            res += st.pop() * st.peek();
        }
        return res;
        
    }
}

class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] row : dp) {  
            Arrays.fill(row, Integer.MAX_VALUE); 
        } 
        for(int i = arr.length-1; i >= 0; i--) {
            for(int j = i; j < arr.length; j++) {
                if(i == j) {
                    dp[i][j] = 0; 
                } else if(j == i+1) {
                    dp[i][j] = arr[i] * arr[j];
                } else {
                    for(int k = i; k < j; k++) {
                        int max1 = 1;
                        for(int p = i; p <= k; p++) {
                            max1 = Math.max(max1, arr[p]);
                        }
                        int max2 = 1;
                        for(int p = k+1; p <= j; p++) {
                            max2 = Math.max(max2, arr[p]);
                        }
                        dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + max1 * max2, dp[i][j]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }
}