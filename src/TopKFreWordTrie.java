import Entity.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class SolutionTKWT {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        PriorityQueue<Trie.TrieNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.getCount() == b.getCount()) return a.getStr().compareTo(b.getStr());
            else return b.getCount() - a.getCount();
        });

        trie.traverse(trie.root, pq);

        while (!pq.isEmpty() && k > 0) {
            result.add(pq.poll().getStr());
            k--;
        }
        return result;
    }
}
public class TopKFreWordTrie {
    public static void main(String[] args) {
        SolutionTKWT trImp = new SolutionTKWT();
        System.out.println(trImp.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));
    }
}
