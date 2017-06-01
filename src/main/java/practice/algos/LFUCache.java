package practice.algos;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {

    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> countMap;
    private Map<Integer, Set<Integer>> freqMap;

    private int capacity;
    private int min = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        valueMap = new HashMap<>();
        countMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (valueMap.get(key) == null) return -1;

        //updating counts
        int count = countMap.getOrDefault(key, 0);
        countMap.put(key, count + 1);

        //updating freq's
        freqMap.get(count).remove(key);
        if (min == count && freqMap.get(count).size() == 0) {
            min = count + 1;
        }
        Set<Integer> set = freqMap.getOrDefault(count + 1, new LinkedHashSet<>());
        set.add(key);
        freqMap.put(count + 1, set);

        return valueMap.get(key);
    }

    public void put(int key, int value) {
        valueMap.put(key, value);

        get(key);
        min = Math.min(countMap.get(key), min);

        if (valueMap.size() > capacity) {
            Set<Integer> set = freqMap.get(min);
            int oldest = set.iterator().next();
            set.remove(oldest);

            if (freqMap.get(min).size() == 0) {
                min = min + 1;
            }
        }
    }

    public static void main(String[] args) {

        LFUCache lfu  = new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);

        lfu.get(1);
        lfu.put(3, 3);

        System.out.println(lfu.get(2));

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
