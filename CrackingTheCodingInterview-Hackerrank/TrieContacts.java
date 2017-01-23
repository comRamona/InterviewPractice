import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class TrieNode{
    public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public int count=0;
    public TrieNode() {
      
    }

   
    
    
}

class Trie{
    private TrieNode root;
   

    public Trie() {
        root = new TrieNode();
    }
    
    public void add(String s){
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!node.children.containsKey(c)) node.children.put(c,new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
      
    }
    
    public int startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.children.containsKey(ch)) {
                return 0;
            }
            node = node.children.get(ch);
        }
        return node.count;
    }
    
}


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();         
        Trie trie = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) trie.add(contact);
            else  System.out.println(trie.startsWith(contact));
        }
      
    }
}
