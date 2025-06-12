import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static java.lang.Thread.sleep;

class NodeF{
    int key;
    int val;
    int frequency;
    public NodeF(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }

    public NodeF() {}
}
class LFUCache {
    int capacity;
    int size;
    int minFrequency;
    Map<Integer,NodeF> cacheMap;
    Map<Integer, LinkedHashSet<NodeF>> frequencyMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.minFrequency = 1;
    }

    public int get(int key) {
        NodeF node = cacheMap.get(key);
        updateFrequency(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            NodeF node = cacheMap.get(key);
            node.val = value;
            updateFrequency(node);
        } else {
            if (cacheMap.size() == capacity) {
                LinkedHashSet list = frequencyMap.get(minFrequency);
                NodeF remove = (NodeF) list.iterator().next();
                list.remove(remove);
                cacheMap.remove(remove.key);
            }
            NodeF node = new NodeF(key, value);
            cacheMap.put(key, node);
            minFrequency = 1;
            frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
        }
    }

    private void updateFrequency(NodeF node){
        int currentFrequency = node.frequency;
        LinkedHashSet list = frequencyMap.get(currentFrequency);
        list.remove(node);
        node.frequency++;
        if(currentFrequency == minFrequency && list.isEmpty()){
            minFrequency++;
        }
        frequencyMap.computeIfAbsent(node.frequency, k->new LinkedHashSet<>()).add(node);
    }
}
public class LFUCACHES {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.get(3);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
