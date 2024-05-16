package andaeys.io.dstruct;

public class EQueue<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public EQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(T element) {
        if (size == array.length) {
            resizeArray();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) array[front];
        array[front] = null; // Avoiding memory leak
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        array = copyArray(newCapacity);
        front = 0;
        rear = size - 1;
    }

    private Object[] copyArray(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0, j = front; i < size; i++, j = (j + 1) % array.length) {
            newArray[i] = array[j];
        }
        return newArray;
    }
}
