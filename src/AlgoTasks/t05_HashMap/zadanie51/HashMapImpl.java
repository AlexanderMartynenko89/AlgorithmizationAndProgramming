package AlgoTasks.t05_HashMap.zadanie51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private class Entry {
        String key;
        V value;

        Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<List<Entry>> table;

    public HashMapImpl() {
        table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        long hash = hashByString(key);
        List<Entry> bucket = table.get((int) hash);

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(0, new Entry(key, value));
    }

    @Override
    public V getValue(String key) {
        long hash = hashByString(key);
        List<Entry> bucket = table.get((int) hash);

        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V delete(String key) {
        long hash = hashByString(key);
        List<Entry> bucket = table.get((int) hash);

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (entry.key.equals(key)) {
                V deletedValue = entry.value;
                bucket.remove(i);
                return deletedValue;
            }
        }
        return null;
    }
}