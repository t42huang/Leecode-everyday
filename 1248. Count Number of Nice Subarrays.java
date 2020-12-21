class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> oddList = new ArrayList<>();
        oddList.add(-1);  
        for(int i=0; i<nums.length; ++i){
            if(nums[i] % 2 == 1)
                oddList.add(i);
        }
        oddList.add(nums.length); 
        
        int res = 0;
        
        int left = 1, right = k + 1;
        while(right < oddList.size() && right - left == k){
            
            int before = oddList.get(left) - oddList.get(left - 1);  
            int after = oddList.get(right) - oddList.get(right - 1);  
            
            res += before * after; 
            left++; 
            right++;
        }
        
        return res;
    }
}