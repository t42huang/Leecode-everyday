class Solution {
    public boolean makesquare(int[] nums) {
        //sum / 4
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        if(total % 4 != 0) return false;
        Arrays.sort(nums);
        return helper(nums, 0, total/4, 0, 1, new boolean[nums.length]);
    }
    
    private boolean helper(int[] nums, int pos, int target, int sum, int groupId, boolean[] visited) {
        if(groupId == 4) return true; //if gd = 4, return true directly
        if(sum == target) return helper(nums, 0, target, 0, groupId + 1, visited);
        if(sum > target) return false;
        
        for(int i = pos; i < nums.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            if(helper(nums, i + 1, target, sum + nums[i], groupId, visited)) return true;
            visited[i] = false;
        }
        
        return false;
    }
}