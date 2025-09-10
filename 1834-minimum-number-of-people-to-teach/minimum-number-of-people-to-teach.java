class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> knows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            knows.add(new HashSet<>());
            for (int lang : languages[i]) {
                knows.get(i).add(lang);
            }
        }
        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; 
            int v = f[1] - 1;
            boolean canTalk = false;
            for (int lang : knows.get(u)) {
                if (knows.get(v).contains(lang)) {
                    canTalk = true;
                    break;
                }
            }
            if (!canTalk) {
                candidates.add(u);
                candidates.add(v);
            }
        }
        if (candidates.isEmpty()) return 0;
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int person : candidates) {
                if (!knows.get(person).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }
        return minTeach;
    }
}