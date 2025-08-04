import java.util.*;

class SolutionADT {
    public String findOrder(String[] words) {
        // code here
       /* ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i =0;i<256;i++){
            adjlist.add(new ArrayList<>());
        }
        int[] chars = new int[256];
        Arrays.fill(chars,-1);
        for(int i = 0;i< words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int id = 0;id<len;id++){
                if(s1.charAt(id) != s2.charAt(id)){
                    chars[s1.charAt(id)-'a'] = 0;
                    chars[s2.charAt(id)-'a'] = 0;
                    adjlist.get(s1.charAt(id)-'a').add(s2.charAt(id)-'a');
                    break;
                }
            }
        }
        List<Integer>topo = findOrderTopo(adjlist,chars);
        String ans = "";
        for(int ch : topo){
            ans+=(char)(ch+(int)'a');
        }
        return ans;*/
        int indegree[] = new int[256];
        Arrays.fill(indegree, -1);
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            adj.add(new ArrayList<>());
        }

        // Register all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c] == -1) {
                    indegree[c] = 0;
                }
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            int len = Math.min(words[i].length(), words[i + 1].length());
            while (j < len && words[i].charAt(j) == words[i + 1].charAt(j)) {
                j++;
            }
            if (j < len) {
                char from = words[i].charAt(j);
                char to = words[i + 1].charAt(j);
                adj.get(from).add(to);
                indegree[to]++;
            } else if (words[i].length() > words[i + 1].length()) {
                // Invalid lexicographical order like ["abc", "ab"]
                return "";
            }
        }

        // Topological sort
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < 256; i++) {
            if (indegree[i] == 0) {
                q.offer((char) i);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.poll();
            str.append(node);
            for (char ch : adj.get(node)) {
                indegree[ch]--;
                if (indegree[ch] == 0) {
                    q.offer(ch);
                }
            }
        }

        // Count active characters
        int active = 0;
        for (int i = 0; i < 256; i++) {
            if (indegree[i] != -1) {
                active++;
            }
        }

        return str.length() == active ? str.toString() : "";
    }

    private List<Integer> findOrderTopo(ArrayList<ArrayList<Integer>> adjList,int[] chars){
        List<Integer> topo = new ArrayList<>();
        int[] inDegree = new int[256];
        for(int i = 0;i<256;i++){
            inDegree[i] = chars[i];
        }

        for(int i = 0;i<256;i++){
            for(int neighbour: adjList.get(i)){
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<256;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int ic = queue.poll();
            topo.add(ic);
            for(int neighbour : adjList.get(ic)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        int active = 0;
        for (int i = 0; i < 256; i++) {
            if (inDegree[i] != -1) {
                active++;
            }
        }
        if(topo.size() == active) return topo;
        return new ArrayList<>();
    }
}
public class AleinDict {
    public static void main(String[] args) {
        SolutionADT ad = new SolutionADT();
        System.out.println(ad.findOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}));
    }
}
