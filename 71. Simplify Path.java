class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        for(String x : path.split("/")){
            if(x.equals("..")){
                if(!s.isEmpty())
                    s.pop(); 
            }else if(x.length() > 0 && !x.equals(".")){ 
                s.add(x);                                
            }
        }
        return "/" + String.join("/",s);
    }
}