/**
https://leetcode.com/problems/unique-paths/
**/
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=1;
        for(int row=m-1;row>=0;row--){
            for(int col=n-1;col>=0;col--){
                int r;
                if(row==m-1||col==n-1)
                    dp[row][col]=1;
                else dp[row][col]=dp[row+1][col]+dp[row][col+1];    
            }
        }
        return dp[0][0];
    }
}