class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        StringBuilder s = new StringBuilder();
        if(k >= num.length()){
            return "0";
        }
        
        for(int i=0; i<num.length(); i++){
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && count < k){
                stack.pop();
                count ++;
            }
            stack.push(num.charAt(i));
        }
        while(count < k){
            stack.pop();
            count ++;
        }
        while(!stack.isEmpty()){
            s.insert(0, stack.pop());
        }
        return s.toString().replaceFirst("^0+(?!$)","");
    }
}