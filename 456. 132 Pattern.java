class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        
        for(int i = 0; i < nums.length - 2; i ++){
            int bigger = nums[i];
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[j] <= nums[i]) continue;
                
                if(nums[j] >= bigger){
                    bigger = nums[j];
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}