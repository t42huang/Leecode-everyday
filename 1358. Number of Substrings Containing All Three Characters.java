class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, res = 0;
        int n = s.length();
        int[] tracker = new int[3];
        while(r<n){
            char c = s.charAt(r);
            tracker[c-'a']++;
            while(tracker[0]>0 && tracker[1]>0 && tracker[2]>0){
                res = res + n - r;
                tracker[s.charAt(l++) - 'a']--;
            }
            r++;
        }
        return res;
    }
}