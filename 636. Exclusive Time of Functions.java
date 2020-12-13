class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] totalTime = new int[n];
        
        Stack<LogLine> stack = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            LogLine l = new LogLine(log.split(":"));
            if(l.isStart){
                if(!stack.isEmpty()){
                    LogLine prev = stack.peek();
                    totalTime[prev.id] += l.time - prevTime;
                }
                prevTime = l.time;
                stack.push(l);
            } else{
                totalTime[l.id] += l.time - prevTime + 1;
                prevTime = l.time + 1;
                stack.pop();
            }
        }
        return totalTime;
    }
    
    class LogLine{
        int id;
        boolean isStart;
        int time;
        
        public LogLine(String[] logParts){
            this.id = Integer.parseInt(logParts[0]);
            this.isStart = (logParts[1].equals("start"));
            this.time = Integer.parseInt(logParts[2]);
        }
    }
}