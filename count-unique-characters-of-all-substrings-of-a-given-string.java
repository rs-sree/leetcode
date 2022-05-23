class Solution {
    public int uniqueLetterString(String s) {
        // int[][] loc = new int[26][2];
        // for (int i = 0; i < 26; i++) {
        //     Arrays.fill(loc[i], -1);
        // }
        // int answer = 0, len = s.length();
        // for (int i = 0; i < len; i++) {
        //     int index = s.charAt(i) - 'A';
        //     answer += (loc[index][1] - loc[index][0]) * (i - loc[index][1]);
        //     loc[index] = new int[] {loc[index][1], i};
        // }
        // for (int i = 0; i < 26; i++) {
        //     answer += (loc[i][1] - loc[i][0]) * (len - loc[i][1]);
        // }
        // return answer;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] contribute = new int[26];
        int cur = 0;
        int prev = 0;
        int res =0;
        for(int i =0; i<n; i++){
            int index = ch[i]-'A';
            cur = prev - contribute[index] + i - last[index];
            contribute[index] = i-last[index];
            last[index] = i;
            res += cur;
            prev = cur;
        }
        return res;
    }
}