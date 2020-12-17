class Solution {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int l = 0;
        int r = 0;
        int res = Integer.MIN_VALUE;
        int cnt = 0;
        while(l < n && r < n) {
            if(A[r] == 1) {
                cnt++;
                r++;
            }else if(A[r] == 0 && K > 0) {
                cnt++;
                K--;
                r++;
            }else if(A[r] == 0 && K == 0) {
                res = Math.max(res, cnt);
                while(K <= 0) {
                    cnt--;
                    if(A[l] == 0) K++;
                    l++;
                }
            }
        }
        res = Math.max(cnt, res);
        return res;
    }
}