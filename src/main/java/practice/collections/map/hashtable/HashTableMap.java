package practice.collections.map.hashtable;

import java.util.*;

public class HashTableMap<K, V> implements Map<K, V> {

    private int bucketsCount = 1010;

    private ArrayList<LinkedList<Pair>> buckets = new ArrayList<LinkedList<Pair>>();
    {
        for (int i = 0; i < bucketsCount; i++) {
            buckets.add(new LinkedList<Pair>());
        }
    }

    @Override
    public int size() {
        // BEGIN (write your solution here)
        int size = 0;
        for (LinkedList<Pair> bucket : buckets) {
            size = size + bucket.size();
        }
        return size;
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        for (LinkedList<Pair> bucket : buckets) {
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
        // END
    }

    @Override
    public boolean containsKey(Object key) {
        // BEGIN (write your solution here)
        for (Pair pair : buckets.get(key.hashCode() % bucketsCount)) {
            if (pair.getKey().equals(key)) {
                return true;
            }
        }
        return false;
        // END
    }

    @Override
    public boolean containsValue(Object value) {
        // BEGIN (write your solution here)
        for (LinkedList<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                if (pair.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
        // END
    }

    @Override
    public V get(Object key) {
        // BEGIN (write your solution here)
        for (Pair pair : buckets.get(key.hashCode() % bucketsCount)) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
        // END
    }

    @Override
    public V put(K key, V value) {
        for (Pair pair : buckets.get(key.hashCode() % bucketsCount)) {
            if (pair.getKey().equals(key)) {
                pair.value = value;
                return value;
            }
        }
        buckets.get(key.hashCode() % bucketsCount).add(new Pair(key, value));
        return null;
        // END
    }

    @Override
    public V remove(Object key) {
        // BEGIN (write your solution here)
        Iterator<Pair> iterator = buckets.get(key.hashCode() % bucketsCount).iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.getKey().equals(key)) {
                V result = next.getValue();
                iterator.remove();
                return result;
            }
        }
        return null;
        // END
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : (Set<Entry<K, V>>) (Set) m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        buckets.clear();
        // END
    }

    @Override
    public Set<K> keySet() {
        final Set<K> keys = new HashSet<K>();
        for (LinkedList<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                keys.add(pair.getKey());
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        // BEGIN (write your solution here)
        LinkedList<V> values = new LinkedList<V>();
        for (LinkedList<Pair> bucket : buckets) {
            for (Pair pair : bucket) {
                values.add(pair.getValue());
            }
        }
        return values;
        // END
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>) (Set) new HashSet<>(buckets);
    }

    private class Pair implements Map.Entry<K, V> {

        private final K key;

        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;

            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
    }
}