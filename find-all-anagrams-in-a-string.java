class Solution {
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res=new ArrayList<>();
    if(p.length()>s.length()) return res;
    int n=p.length(),m=s.length();
    int freq[]=new int[26];

    for(int i=0;i<n;i++){
        freq[p.charAt(i)-'a']++;
        freq[s.charAt(i)-'a']--;
    }
    if(isValid(freq)) res.add(0);

    for(int i=n;i<m;i++){
        freq[s.charAt(i-n)-'a']++;
        freq[s.charAt(i)-'a']--;
        if(isValid(freq)) res.add(i-n+1);
    }
    return res;
    
}

public boolean isValid(int freq[]){
    for(int i=0;i<26;i++){
        if(freq[i]!=0) return false;
    }
    return true;
}
}