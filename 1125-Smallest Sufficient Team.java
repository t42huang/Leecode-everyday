class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = createSkillsMap(req_skills);
        int[] peopleSkills = createPeopleSkills(people, map);
        return calculateSmallestTeam(map, peopleSkills).stream().mapToInt(i->i).toArray();
    }
    
    private Map<String, Integer> createSkillsMap(String[] skills) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<skills.length; i++) {
            map.put(skills[i], i);
        }
        return map;
    }
    
    private int[] createPeopleSkills(List<List<String>> people, Map<String, Integer> map) {
        int[] peopleSkills = new int[people.size()];
        
        for(int i=0; i<people.size(); i++) {
            int value = 0;
            
            for(String skill: people.get(i)) {
                value |= 1 << map.get(skill);
            }
            
            peopleSkills[i] = value;
        }
        return peopleSkills;
    }
    
    private List<Integer> calculateSmallestTeam(Map<String, Integer> map, int[] skills) {
        int n = skills.length;
        int m = 1 << map.size();
        
        List<List<Integer>> dp = new ArrayList<>(Collections.nCopies(m, null));
        dp.set(0, new ArrayList<>());
        
        for(int i=0; i<n; i++) {
            int value = skills[i];
            if(dp.get(value) == null || dp.get(value).size()>1) {
                dp.set(value, Arrays.asList(i));
            }
            
            for(int j=0; j<m; j++) {
                int cur = j | value;
                List<Integer> prev = dp.get(j);
                
                if(prev != null && (dp.get(cur) == null || prev.size() + 1 < dp.get(cur).size())) {
                    dp.set(cur, new ArrayList<>(prev));
                    dp.get(cur).add(i);
                }
            }
        }
        return dp.get(m-1);
    }
}