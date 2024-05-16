package andaeys.io.dstruct;

public class EPriorityQueue<T extends Comparable<T>> {
    private Object[] heap;
    private int size;

    public EPriorityQueue(int capacity) {
        heap = new Object[capacity];
        size = 0;
    }

    public void add(T value) {
        if (size == heap.length) {
            throw new IllegalStateException("Queue is full");
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) heap[0];
    }

    public T poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return value;
    }

    public void traverseOrder() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void heapifyUp(int index) {
        T value = (T) heap[index];
        while (index > 0) {
            int parent = (index - 1) / 2;
            T parentValue = (T) heap[parent];
            if (value.compareTo(parentValue) < 0) {
                heap[index] = parentValue;
                heap[parent] = value;
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        T value = (T) heap[index];
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            int smallerChild = leftChild;
            if (rightChild < size && ((T) heap[rightChild]).compareTo((T) heap[leftChild]) < 0) {
                smallerChild = rightChild;
            }

            T childValue = (T) heap[smallerChild];
            if (childValue.compareTo(value) < 0) {
                heap[index] = childValue;
                heap[smallerChild] = value;
                index = smallerChild;
            } else {
                break;
            }
        }
    }
}
