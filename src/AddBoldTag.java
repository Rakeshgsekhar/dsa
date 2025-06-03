

import java.util.ArrayList;
import java.util.List;

class Trie {
    // Trie node array covering ASCII characters
    Trie[] children = new Trie[128];
    // Flag to indicate the end of a word
    boolean isEndOfWord;

    // Insert a word into the trie
    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            if (node.children[ch] == null) {
                node.children[ch] = new Trie();
            }
            node = node.children[ch];
        }
        node.isEndOfWord = true;
    }
}
class SolutionADB {
    // Function to add bold tags around substrings in 's' that appear in 'words'
    public String addBoldTag(String s, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        List<int[]> interval = new ArrayList<>();
        int len=s.length();
//        for(int i = 0;i<len;++i){
//            Trie node = trie;
//            for(int j = i;j<len;++j){
//                char ch = s.charAt(j);
//                if(node.children[ch] == null) break;
//                node = node.children[ch];
//                if(node.isEndOfWord){
//                    interval.add(new int[]{i,j});
//                }
//            }
//        }
//        if(interval.isEmpty()) return s;

        for(String word : words){
            if(s.contains(word)){
                int start = s.indexOf(word);
                int end = start+word.length()-1;
                interval.add(new int[]{start,end});
            }
        }
        if(interval.isEmpty()) return s;

        List<int[]> merged = new ArrayList<>();
        int start = interval.get(0)[0],end = interval.get(0)[1];

        for(int i = 1;i<interval.size();i++){
            int currentStart = interval.get(i)[0],currentEnd = interval.get(i)[1];
            if(currentStart<end+1){
                end = Math.max(end,currentEnd);
            }else{
                merged.add(new int[]{start,end});
                start = currentStart;
                end = currentEnd;
            }
        }
        merged.add(new int[]{start,end});

//        StringBuilder res = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        int currentIndex = 0, mergedIndex = 0;

        while (currentIndex < len) {
            if (mergedIndex == merged.size()) {
                result.append(s.substring(currentIndex));
                break;
            }
            start = merged.get(mergedIndex)[0];
            end = merged.get(mergedIndex)[1];

            // Add non-bold part of the string
            if (currentIndex < start) {
                result.append(s.substring(currentIndex, start));
            }

            // Move to the next interval
            ++mergedIndex;

            // Enclose the substring within <b> tags
            result.append("<b>")
                    .append(s.substring(start, end + 1))
                    .append("</b>");

            // Update the currentIndex to the end of the bold section
            currentIndex = end + 1;
        }

        return result.toString();
    }
}
public class AddBoldTag {
    public static void main(String[] args) {
        SolutionADB adb = new SolutionADB();
        System.out.println(adb.addBoldTag("abcxyz123",new String[]{"abc","123"}));
/*
        String s = "abcxyz123";
        String [] words = new String[]{"abc","123"};
        StringBuilder sb = new StringBuilder(s);
        List<int[]> interval = new ArrayList<>();
        for(String word : words){
            if(s.contains(word)){
                int start = s.indexOf(word);
                int end = start+word.length()-1;
                interval.add(new int[]{start,end});
            }
//            System.out.println(s.contains(word));
//            System.out.println(s.indexOf(word));
        }
        interval.forEach(inte-> System.out.println("["+inte[0]+","+inte[1]+"]"));
        System.out.println(interval);

 */
    }
}
