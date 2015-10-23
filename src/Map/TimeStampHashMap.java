package Map;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

/**
 * Created by zxm on 10/23/15.
 */

class Pair<K, Integer> {
    private K key;
    private Integer timeStamp;
    public Pair(K key, Integer timeStamp) {
        this.key = key;
        this.timeStamp = timeStamp;
    }
    @Override
    public int hashCode() {
        return key.hashCode() + timeStamp.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        if (this == object) return true;
        Pair p = (Pair) object;
        return key.equals(p.key) && timeStamp.equals(p.timeStamp);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }
}
public class TimeStampHashMap<K, V> {
    private Map<Pair, V> valueMap;
    private Map<K, Integer> lastestTimeMap;

    public TimeStampHashMap() {
        valueMap = new HashMap<>();
        lastestTimeMap = new HashMap<>();
    }
    public void put(K key, V value, Integer timeStamp) {
        valueMap.put(new Pair(key, timeStamp), value);
        Integer lastTimeStamp = lastestTimeMap.get(key);
        if (lastTimeStamp.intValue() < timeStamp.intValue()) lastestTimeMap.put(key, timeStamp);
    }

    public V get(K key, Integer timeStamp) {
        Pair pair = new Pair(key, timeStamp);
        if (! valueMap.containsKey(pair)) throw new IllegalArgumentException("The key does not exist");
        return valueMap.get(pair);
    }

    public V getLatest(K key) {
        if (! lastestTimeMap.containsKey(key)) throw new IllegalArgumentException("The key does not exist");
        Pair pair = new Pair(key, lastestTimeMap.get(key));
        return valueMap.get(pair);
    }

    public Map<Pair, V> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<Pair, V> valueMap) {
        this.valueMap = valueMap;
    }

    public Map<K, Integer> getLastestTimeMap() {
        return lastestTimeMap;
    }

    public void setLastestTimeMap(Map<K, Integer> lastestTimeMap) {
        this.lastestTimeMap = lastestTimeMap;
    }
}
