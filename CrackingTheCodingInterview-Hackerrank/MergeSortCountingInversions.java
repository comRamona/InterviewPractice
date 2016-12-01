import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long countInversions(int[] arr){
    long res=mergeSort(arr,0,arr.length-1,0);
    return res;
    }
    public static long mergeSort(int[] arr,int i,int j,long inv){
        if(i<j){
           int m=(i+j)/2;
           long count=0;
           count+=mergeSort(arr,i,m,inv);
           count+=mergeSort(arr,m+1,j,inv);
           count+=merge(arr,i,m,j);
           return count;
        }
        else return 0;
    }
    public static long merge(int[] arr,int i,int m,int j){
        int p=i;
        int q=m+1;
        int[] b=new int[j-i+1];
        int c=0;
        long inv=0;
        while(p<=m&&q<=j){
            if(arr[p]>arr[q]){
                b[c]=arr[q];
                q++;
                c++;
                // Tricky part, because you have to shift everything left in the left part
                inv += m-p + 1;
            
            }
            else {
                b[c]=arr[p];
                p++;
                c++;
            }
        }
        while(p<=m){
             b[c]=arr[p];
                p++;
                c++;
        }
        while(q<=j){
             b[c]=arr[q];
                q++;
                c++;
        }
       
        for(int k=0;k<b.length;k++){
            arr[i+k]=b[k];
           
        }
        return inv;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }
    
    
}
