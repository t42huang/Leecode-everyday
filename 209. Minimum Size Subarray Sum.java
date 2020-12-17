class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        if(nums.length > 0 || nums != null) {
            int prefixSum = 0;
            int l = 0;
            
            for(int i = 0; i< nums.length; i++){
                prefixSum += nums[i];
                
                while(prefixSum >= s){
                    res = Math.min(res, i+1-l);
                    prefixSum -= nums[l];
                    l ++;
                }
            }
        }
        
        return ((res != Integer.MAX_VALUE) ? res : 0);
    }
}