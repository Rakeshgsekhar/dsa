import java.util.HashMap;
import java.util.Map;

class NodeC{
    int key;
    int val;
    NodeC next;
    NodeC prev;



    public NodeC(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;

    }

    public NodeC() {}
}
class LRUCaches {
    int capacity;
    int size;
    NodeC head;
    NodeC tail;
    Map<Integer,NodeC> cacheMap;
    public LRUCaches(int capacity) {
        this.head = new NodeC(-1,-1);
        this.tail = new NodeC(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if(this.cacheMap.size() == 0) return -1;
        NodeC node = this.cacheMap.get(key);
        if(node == null) return -1;
        delete(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
       if(this.cacheMap.containsKey(key)){
           NodeC node = this.cacheMap.get(key);
           delete(node);
       }
        NodeC newNode = new NodeC(key,value);
        this.cacheMap.put(key,newNode);
        add(newNode);


       if(this.cacheMap.size()>this.capacity){
            NodeC toDelete = this.tail.prev;
            delete(toDelete);
            cacheMap.remove(toDelete.key);
       }

    }

    private void add(NodeC node){
        NodeC nextNode = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = nextNode;
        nextNode.prev = node;
    }
    private void delete(NodeC node){
        NodeC prevNode = node.prev;
        NodeC nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
public class LRUCACHE {
    public static void main(String[] args) {
        LRUCaches cache = new LRUCaches(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
