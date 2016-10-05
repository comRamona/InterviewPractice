public class LongestCommonSubstring{
public static String longest(String S,String T){
  int[][] table=new int[S.length()+1][T.length()+1];
  int maxLen=0;
  String result=null;
  for(int i=1;i<=S.length();i++){
    for(int j=1;j<=T.length();j++){
      if(S.charAt(i-1)==T.charAt(j-1)){
        table[i][j]=table[i-1][j-1]+1;
        if(table[i][j]>maxLen){
          maxLen=table[i][j];
          result=S.substring(i-maxLen,i);
        }
      }
    }
  }
  System.out.println(maxLen);
  return result;
}
public static void main(String[] args){
  System.out.println(longest("ababc","babac"));
    System.out.println(longest("abac","babac"));

}
}
