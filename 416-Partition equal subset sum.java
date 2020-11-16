class Solution {
    //DP
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }
        
        if(total % 2 != 0) return false;
        total /= 2;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        
        for(int num : nums) {
            for(int j = total; j >= 0; j--) {
                if(j >= num) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[total];
    }
} 

class Solution {        
    public boolean canPartition(int[] nums) {
        int total = 0; // sum of all elements in nums
        for(int num: nums) {
            total += num;
        }
        
        if(total % 2 != 0) return false; 
        
        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }
    public boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state) {
        String current = index + "" + sum;
        if(state.containsKey(current)) {
            return state.get(current);
        }
        if(sum * 2 == total) { // subset sum is equal to total/2, then return true
            return true;
        }
        if(sum > total / 2 || index >= nums.length) {
            return false;
        }
        
        boolean res = canPartition(nums, index + 1, sum, total, state) || canPartition(nums, index + 1, sum + nums[index], total, state);
        state.put(current, res);
        return res;
    }
}


class Solution {
    //backtrack
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }
        
        if(total % 2 != 0) return false;
        total /= 2;
        return helper(nums, 0, total); // nums, index, toalsum
    }
    
    public boolean helper(int[] nums, int index, int target) {
        if(target == 0) return true;
        if(index == nums.length || target < 0) return false;
        if(helper(nums, index + 1, target - nums[index])) return true;
        
        //Time exceed
        //Skip the same elements
        int j = index + 1;
        while(j < nums.length && nums[index] == nums[j]) {
            j ++;
        }
        return helper(nums, j, target);
    }
}