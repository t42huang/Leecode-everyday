class Solution {
    public boolean parseBoolExpr(String expression) {        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == ',')
                continue;            
            if(ch != ')'){
                stack.push(ch);
            }
            else{
                int trueCount = 0, falseCount = 0;
                while(!stack.isEmpty() && stack.peek() != '('){
                    if(stack.pop() == 't')
                        trueCount++;
                    else
                        falseCount++;
                }                
                stack.pop();
                
                char op = stack.pop();
                
                if(op == '|')
                    stack.push(trueCount > 0 ? 't' : 'f');
                else if(op == '&')
                    stack.push(falseCount > 0 ? 'f' : 't');
                else if(op == '!')
                    stack.push(trueCount > 0 ? 'f' : 't');
            }
        }
        
        return stack.peek() == 't' ? true : false; 
    }
    
}