import java.util.Arrays;

class TreeNode{
    TreeNode[] children = new TreeNode[2];
    TreeNode(){
        Arrays.fill(children,null);
    }
}


class TrieB{
    TreeNode root;
    TrieB(){
        root = new TreeNode();
    }

    public void insert(int num){
        TreeNode node = root;
        for(int i = 30;i>=0;i--){
            int bit = (num>>i)&1;
            if(node.children[bit] == null){
                node.children[bit] = new TreeNode();
            }
            node = node.children[bit];
        }
    }

    public int search(int num){
        TreeNode node = root;
        int val = 0;
        for(int i = 30;i>=0;i--){
            int bit = (num>>i)&1;
            if(node.children[bit^i] != null){
                val+=(1<<i);
                node = node.children[bit^i];
            }else{
                node = node.children[bit];
            }
        }
        return val;
    }
}

class SolutionArrMaXOR {
    public int findMaximumXOR(int[] nums) {
        TrieB trieB = new TrieB();
        for(int num : nums){
            trieB.insert(num);
        }
        int ans = Integer.MIN_VALUE;
        for(int num : nums){
            ans = Math.max(ans,trieB.search(num));
        }
        return ans;
    }
}
public class MaxXoRofTwoNumbersInArray {
}
