package andaeys.io.dstruct;

public class EHashSet<E> {
    private class Entry<E> {
        E e; Entry<E> next;
        public Entry(E e){
            this.e=e;
        }
    }
    private Entry<E>[] buckets;
    private static final int CAPACITY = 32;
    int size;

    public EHashSet(){
        buckets = new Entry[CAPACITY];
        size = 0;
    }

    private int geBucketIndex(E e){
        return e.hashCode() % buckets.length;
    }

    public void add(E e){
        Entry<E> newEntry = new Entry<>(e);
        int idx = geBucketIndex(e);
        Entry<E> head  = buckets[idx];

        Entry<E> current = head;
        while (current!=null){
            if(current.e.equals(e)){
                return;
            }
            current = current.next;
        }
        newEntry.next = head;
        buckets[idx] = newEntry;
        size++;
    }

    public boolean contains(E e){
        int idx = geBucketIndex(e);
        Entry<E> current  = buckets[idx];
        while (current!=null){
            if(current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(E e){
        int idx = geBucketIndex(e);
        Entry<E> current  = buckets[idx];
        Entry<E> prev  = null;
        while (current!=null){
            if(current.e.equals(e)){
                if (prev==null){
                    buckets[idx] = current.next;
                }else{
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
