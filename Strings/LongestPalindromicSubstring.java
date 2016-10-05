public class LongestPalindromicSubstring{
public static String longest(String s){
  int n=s.length();
  boolean[][] table=new boolean[n][n];
  String result=s.substring(0,1);
  table[n-1][n-1]=true;
  for(int i=0;i<n-1;i++){
    table[i][i]=true;
    if(s.charAt(i)==s.charAt(i+1)){
      table[i][i+1]=true;
      result=s.substring(i,i+2);
    }
  }
  for(int len=3;len<=n;len++){
    for(int start=0;start<=n-len;start++){
      if(s.charAt(start)==s.charAt(start+len-1)){
        if(table[start+1][start+len-2]==true){
          table[start][start+len-1]=true;
          result=s.substring(start,start+len);
        }
      }
    }
  }
  return result;
}

public String longestPalindrome2(String s) {
	if (s.isEmpty()) {
		return null;
	}

	if (s.length() == 1) {
		return s;
	}

	String longest = s.substring(0, 1);
	for (int i = 0; i < s.length(); i++) {
		// get longest palindrome with center of i
		String tmp = helper(s, i, i);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}

		// get longest palindrome with center of i, i+1
		tmp = helper(s, i, i + 1);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
	}

	return longest;
}

// Given a center, either one letter or two letter,
// Find longest palindrome
public String helper(String s, int begin, int end) {
	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
		begin--;
		end++;
	}
	return s.substring(begin + 1, end);
}
public static void main(String[] args){
  System.out.println(longest("aa"));
  System.out.println(longest("abcdcbba"));

}


}
