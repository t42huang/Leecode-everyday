class Solution {
    int index = 0;
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int res  = get(s);
        return res;
    }
    public int get(String s) {
        if(index >= s.length()) return 0;
        
        int res = 0;
        char sign = '+';
        //calculate normal number
        while(index < s.length()){
            int cur = 0;
            //build the number
            if(s.charAt(index) == '(') {
                index ++;  //cur jump to next number
                cur = get(s);
            }else{
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    cur = cur*10 + (s.charAt(index) - '0');
                    index ++;
                }
            }
            
            //calculate the previous
            if(sign == '+'){
                res += cur;
            }else if(sign == '-'){
                res -= cur;
            }
            
            //break point
            if(index<s.length() && s.charAt(index) == ')'){
                index ++;
                break;
            }
            //update sign
            if(index<s.length()) sign = s.charAt(index);
            index ++;
        }
        return res;
    }
}