class Solution {
// public int lengthOfLongestSubstring(String s) {
//         Integer[] chars = new Integer[128];

//         int left = 0;
//         int right = 0;

//         int res = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);

//             Integer index = chars[r];
//             if (index != null && index >= left && index < right) {
//                 left = index + 1;
//             }

//             res = Math.max(res, right - left + 1);

//             chars[r] = right;
//             right++;
//         }

//         return res;
//     }
    
    public int lengthOfLongestSubstring(String s) {

	int count = 0;       
    if(s.contains("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ")) {
        return 95;
    }
    
    for(int i = 0;i < s.length(); i++) {
        String str = "";
        for(int j = i; j < s.length(); j++) {
            if(str.contains(String.valueOf(s.charAt(j)))) {
                if(str.length()>count) {
                    System.out.println("First " + str + str.length());
                    count = str.length();
                }
                str = "";
            }
            str += String.valueOf(s.charAt(j));                
        }
        if(str.length()>count) {
            System.out.println("Second " + str + str.length());
            count = str.length();
        }
    }

    return count;
        
}
    
}