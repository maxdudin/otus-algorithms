package otus.arrays;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;
    private int size;

    public SingleArray () {
        array = new Object[0];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
//        for (int j = 0; j < size(); j ++)
//            newArray[j] = array[j];
        array = newArray;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(T item, int index) {
        resize();
        T temp = (T) array[index];
        T swap;
        array[index] = item;
        for (int i = index + 1; i < array.length; i++) {
            swap = (T) array[i];
            array[i] = temp;
            temp = swap;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T removed = (T) array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public void set(T item, int index) {
        array[index] = item;
    }
}
