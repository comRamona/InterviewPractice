//https://leetcode.com/problems/word-ladder/#/description

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
           if(endWord.equals(beginWord)){
               return 0;
           }
           HashMap<String,Integer> visited = new HashMap();
           Queue<String> queue = new LinkedList<String>();
           Set<String> wordSet = new HashSet<>(wordList);
        
           queue.offer(beginWord);
           visited.put(beginWord,1);
           while(!queue.isEmpty()){
               
               String next = queue.remove();
               int count=visited.get(next);
                        //System.out.println("BLA "+next);
               for(int i=0;i<next.length();i++){
                   for(char c='a';c<='z';c++){
                       String nextWord=next.substring(0,i)+c+next.substring(i+1,next.length());

                        //System.out.println(nextWord+" "+count);
                       if(nextWord.equals(next)) {
                           continue;
                       }
                        
                       
                       if(!visited.containsKey(nextWord) && wordSet.contains(nextWord)){
                           visited.put(nextWord,count+1);
                           queue.offer(nextWord);
                            if(nextWord.equals(endWord))
                               return count+1;
                         
                       }
                   }
               }
             
           }
           return 0;
    }
}
