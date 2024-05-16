package andaeys.io.dstruct;

public class EStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] array;
    private int size;

    public EStack() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = (T) array[--size];
        array[size] = null; // Avoiding memory leak
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        array = copyArray(newCapacity);
    }

    private Object[] copyArray(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
