class Solution {
    public int calculate(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        char operater = '+';
        for(int i=0; i<len; i++){
            char curChar = s.charAt(i);
            if(Character.isDigit(curChar)){
                cur = cur * 10 + curChar - '0';
            }
            
            if(!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == len - 1){
                if(operater == '-'){
                    stack.push(-cur);
                }
                else if(operater == '+'){
                    stack.push(cur);
                }
                else if(operater == '*'){
                    stack.push(stack.pop() * cur);
                }
                else if(operater == '/'){
                    stack.push(stack.pop() / cur);
                }
                operater = curChar;
                cur = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;       
    }
}

// class Solution {
//     public int calculate(String s) {
        
//         int res = 0, pre = 0, curr = 0;
//         char sign = '+';
//         char[] array = s.trim().toCharArray();
//         for(int i=0; i<=array.length; i++){
//             if(i!=array.length && Character.isDigit(array[i]))
//                 curr = curr*10 + array[i]-'0';
//             else{
//                 if(i!=array.length && array[i]==' ') continue;
//                 if(sign=='+'){
//                     res += curr;
//                     pre = curr;
//                 }
//                 if(sign=='-'){
//                     res -= curr;
//                     pre = -curr;
//                 }
//                 if(sign=='*'){
//                     res = res - pre + pre*curr;
//                     pre = pre*curr;
//                 }
//                 if(sign=='/'){
//                     res = res - pre + pre/curr;
//                     pre = pre/curr;
//                 }
//                 curr = 0;
//                 if(i!=array.length) sign = array[i];
//             }
//         }
//         return res;
//     }
// }