class Solution {
    public int maxWidthRamp(int[] A) {
        
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i< A.length; i++){
            if(stack.isEmpty() || A[stack.peek()] > A[i]){
                stack.push(i);
            }
        }
        
        for(int i=A.length - 1; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                res = Math.max(res, i-stack.peek());
                stack.pop();
            }
        }
        return res;
    }
}