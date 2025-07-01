import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class NodeNR {
    public int val;
    public NodeNR left;
    public NodeNR right;
    public NodeNR next;

    public NodeNR() {}

    public NodeNR(int _val) {
        val = _val;
    }

    public NodeNR(int _val, NodeNR _left, NodeNR _right, NodeNR _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class SolutionNR {
    public NodeNR connect(NodeNR root) {
        List<List<NodeNR>> list = new ArrayList<>();
        if(root == null) return null;
        compute(root,0,list);
        for(List<NodeNR> level : list){
            if(level.size() == 1) level.get(0).next = null;
            for(int i = 1;i<level.size();i++){
               level.get(i-1).next = level.get(i);
            }
        }
        return root;
    }
    private void compute(NodeNR node,int level,List<List<NodeNR>> result){
        if(node == null) return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node);
        compute(node.left,level+1,result);
        compute(node.right,level+1,result);
    }
}
public class PopulateNextRight {
}
