import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    public static int dfs(int[][] matrix, int i,int j){
        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length) return 0;
        if(matrix[i][j]!=1) return 0;
        matrix[i][j]=-1; //visited
        return 1+dfs(matrix,i-1,j-1)+dfs(matrix,i-1,j)+dfs(matrix,i-1,j+1)+dfs(matrix,i,j-1)+dfs(matrix,i,j+1)+dfs(matrix,i+1,j-1)+dfs(matrix,i+1,j)+dfs(matrix,i+1,j+1);
    }
    public static int getBiggestRegion(int[][] matrix) {
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    int count=dfs(matrix,i,j);
                    if(count>max) max=count;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
