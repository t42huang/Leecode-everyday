class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        //[xxx[ixxxxj]xxxx]
        //sum[i:j] = prefix[j]-prefix[i-1] = S
        //区间和, hash prefixsum
        int res = 0;
        if(A != null && A.length >0){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int prefixSum = 0;
            for(int i = 0; i < A.length; i++){
                prefixSum += A[i];
                res += map.getOrDefault(prefixSum - S, 0);
                map.put(prefixSum, 1 + map.getOrDefault(prefixSum, 0));
            }
        }
        return res;     
    }
}        
    