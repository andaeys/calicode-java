package andaeys.io.dstruct;

public class EHashMap<K, V> {
    private class Entry<K, V> {
        K key; V value; Entry<K, V> next;
        public Entry(K key, V value){
            this.key = key; this.value = value;
        }
    }

    private Entry<K, V>[] buckets;
    private static final int CAPACITY = 32;

    public EHashMap(){
        buckets = new Entry[CAPACITY];
    }

    private int geBucketIndex(K key){
        return key.hashCode() % buckets.length;
    }

    public void put(K key, V value){
        Entry<K,V> newEntry = new Entry<>(key, value);
        int idx = geBucketIndex(key);
        Entry<K, V> current  = buckets[idx];
        while (current!=null){
            //update
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        newEntry.next = buckets[idx];
        buckets[idx] = newEntry;
    }

    public V get(K key){
        int idx = geBucketIndex(key);
        Entry<K, V> current  = buckets[idx];
        while (current!=null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key){
        int idx = geBucketIndex(key);
        Entry<K, V> current  = buckets[idx];
        Entry<K, V> prev  = null;
        while (current!=null){
            if(current.key.equals(key)){
                if (prev==null){
                    buckets[idx] = current.next;
                }else{
                    prev.next = current.next;
                }
            }
            prev = current;
            current = current.next;
        }
    }
}
