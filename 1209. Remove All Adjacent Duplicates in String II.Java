class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0;
        int cnt = 0;
        String res = s;
        while (i < res.length()) {
            if (i > 0 && res.charAt(i) == res.charAt(i - 1)) {
                ++cnt;
            } else {
                cnt = 1;
            }
            if (cnt == k) {
                res = res.substring(0, i - k + 1) + res.substring(i + 1);
                i = Math.max(0, i - k);
                while (i > 0 && res.charAt(i) == res.charAt(i - 1)) {
                    --i;
                }
            } else {
                ++i;
            }
        }
        return res;
    }
}