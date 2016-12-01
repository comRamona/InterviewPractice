import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static List<String> solution(String s){
        if(s.length()==0) {
            List<String> list=new ArrayList<>();
            list.add("");
            return list;
        }
        else {
            List<String> list=solution(s.substring(0,s.length()-1));
            List<String> res=new ArrayList<>();
            char c=s.charAt(s.length()-1);
            for(String st:list){
                addAtAllPositions(res,st,c);
            }
            return res;
        }
    }
    
    public static void addAtAllPositions(List<String> res,String s,char c){
        int n=s.length();
        for(int i=0;i<=n;i++){
            String r=s.substring(0,i)+c+s.substring(i,n);
            res.add(r);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        List<String> res=solution(s);
        for(String str:res){
            System.out.println(str);
        }
    }
}