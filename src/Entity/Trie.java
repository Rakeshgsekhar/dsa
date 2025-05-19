package Entity;

import java.util.PriorityQueue;

public class Trie {
    static final int numChar = 26;


    public static class TrieNode {
        TrieNode[] children = new TrieNode[numChar];
        boolean isEndOfWord;
        int count;
        String str;

        TrieNode() {
            isEndOfWord = false;
            str = "";
            count = 0;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public int getCount() {
            return count;
        }

        public String getStr() {
            return str;
        }
    }

        public TrieNode root = new TrieNode();

        public void insert(String key){
            int len = key.length();
            TrieNode curr = root;
            for(int level = 0;level<len;level++){
                int index = key.charAt(level)-'a';
                if(curr.children[index] ==null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEndOfWord = true;
            curr.count+=1;
            curr.str = key;
        }

        public void traverse(TrieNode root, PriorityQueue<Trie.TrieNode>pq){
            if(root == null) return;
            if(root.isEndOfWord){
                pq.add(root);
            }
            for(int i = 0;i<numChar;i++){
                traverse(root.children[i],pq);
            }
        }

}
