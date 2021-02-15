//1337. The K Weakest Rows in a Matrix
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        if(mat == null) return null;
        int m = mat.length;
        int n =0;
        if(mat[0] != null)
            n = mat[0].length;
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            int j=0;
            int soldiersNum = 0;
            while(j<n){
                if(mat[i][j] == 1)
                    soldiersNum ++;
                else
                    break;
                j++;
            }
            map.put(i, soldiersNum);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1,o2) ->{
            return o1.getValue() - o2.getValue();
        });
        for(int i=0; i<k; i++){
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}