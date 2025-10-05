
class TrieSuffixNode{
    public int index;
    public TrieSuffixNode[] children;

    public TrieSuffixNode() {
        index = Integer.MAX_VALUE;
        children = new TrieSuffixNode[26];
    }
}


class TrieSuffix{
    private TrieSuffixNode root;
    private String[] words;

    public TrieSuffix(String[] words) {
        int n = words.length;
        root = new TrieSuffixNode();
        this.words = words;
        for (int i = 0; i < n; i++) {
            insertSuffix(words[i], i);
        }
        fillIndices(root);
    }

    private int fillIndices(TrieSuffixNode curr) {
        for (TrieSuffixNode child: curr.children) {
            int r = child != null ? fillIndices(child) : Integer.MAX_VALUE;
            if (change(curr.index, r)) {
                curr.index = r;
            }
        }
        return curr.index;
    }

    private boolean change(int i, int j) {
        int n = words.length;
        return (0 <= j && j < n) &&
                (!(0 <= i && i < n) ||
                        words[j].length() < words[i].length() ||
                        (words[j].length() == words[i].length() && j < i));
    }

    private void insertSuffix(String word, int index){
        TrieSuffixNode node = root;
        char[] strs = word.toCharArray();
        for(int i = words.length-1;i>=0;i--){
            if(node.children[strs[i]-'a'] == null){
                node.children[strs[i]-'a'] = new TrieSuffixNode();
            }
            node = node.children[strs[i]-'a'];
        }
        node.index = Math.min(node.index,index);
    }

    public int longestCommonSuffix(String s) {
        TrieSuffixNode curr = root;
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0 && curr.children[str[i] - 'a'] != null; i--) {
            curr = curr.children[str[i] - 'a'];
        }
        return curr.index;
    }
}
public class LongestCommonSuffixQ {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsQuery.length;
        TrieSuffix trie = new TrieSuffix(wordsContainer);
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = trie.longestCommonSuffix(wordsQuery[i]);
        }
        return result;
    }
}
