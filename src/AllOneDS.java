import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class NodeA{
    String key;
    int count;
    NodeA next;
    NodeA prev;
    NodeA(){}
    NodeA(String key){
        this.key = key;
        this.count = 1;
        this.next = null;
        this.prev = null;
    }
}
class AllOne {
    NodeA head;
    NodeA tail;
    HashMap<String,NodeA> cache ;
    PriorityQueue<NodeA> minQueue ;
    PriorityQueue<NodeA> maxQueue ;

    public AllOne() {
        head = new NodeA("#");
        tail = new NodeA("#");
        head.next = tail;
        tail.prev = head;
        this.cache = new HashMap<>();
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<NodeA>((a,b)->Integer.compare(b.count,a.count));
    }

    public void inc(String key) {
        if(cache.containsKey(key)){
            NodeA node = cache.get(key);
            node.count++;
            removeNode(node);
            updateCache(node);
            cache.put(key,node);
        }else{
            NodeA newNode = new NodeA(key);
            addNode(newNode);
            cache.put(key,newNode);
        }

    }

    public void dec(String key) {
        NodeA decNode = cache.get(key);
        decNode.count--;
        removeNode(decNode);
        if(decNode.count == 0){
            cache.remove(key);
        }else {
            addNode(decNode);
            cache.put(key,decNode);
        }
    }

    public String getMaxKey() {
        if(this.head.next == tail) return "";
        return this.tail.prev.key;
    }

    public String getMinKey() {
        if(this.head.next == tail) return "";
        return this.head.next.key;
    }
    private void updateCache(NodeA node){
        NodeA temp = head;
        while(temp!=null && temp.count<=node.count){
            temp = temp.next;
        }
        if(temp == null){
            if(head.next == tail){
                addNode(node);
            }else {
                NodeA prevN = tail;
                if(tail.prev.count>node.count)
                    prevN = prevN.prev;
                node.prev = prevN.prev;
                prevN.prev.next = node;
                node.next = prevN;
                prevN.prev = node;
            }
        }else{
            NodeA prev = temp.prev;
            prev.next = node;
            node.prev = prev;
            node.next = temp;
            temp.prev = node;
        }
    }

    private void addNode(NodeA node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(NodeA node){
        NodeA prev = node.prev;
        if(prev!=null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }else{
            head.next = node.next;
            node.next.prev = head;
        }
    }
}
public class AllOneDS {
    public static void main(String[] args) {
        AllOne aone = new AllOne();
        aone.inc("hello");
        aone.inc("Good Bye");
        aone.inc("hello");
        aone.inc("hello");
        System.out.println(aone.getMaxKey());
//        System.out.println(aone.getMinKey());
        aone.inc("leet");
        aone.inc("code");
        aone.inc("leet");
        aone.dec("hello");
        aone.inc("leet");
        aone.inc("code");
        aone.inc("code");
        System.out.println(aone.getMaxKey());
//        System.out.println(aone.getMinKey());
    }
}
