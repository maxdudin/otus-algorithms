package otus.arrays;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(3);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<>(vector));
        array.get(size / vector).add(item);
        size++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public void add(T item, int index) {
        int arrayToAccess = index / vector;
        int position = index % vector;

        if (size % vector == 0) {
            array.add(new VectorArray<>(vector));
        }

        T temp = array.get(arrayToAccess).get(position);
        T swap;
        array.get(arrayToAccess).set(item, position);

        for (int i = position + 1; i < vector; i++) {
            swap = array.get(arrayToAccess).get(i);
            array.get(arrayToAccess).set(temp, i);
            temp = swap;
        }

        for (int i = arrayToAccess + 1; i < array.size(); i++) {
            for (int j = 0; j < vector; j++) {
                //add only one than break

                if ((i + 1) == array.size() && ((i * vector) + j == size)) {
                    array.get(i).set(temp, j);
                    break;
                }

                swap = array.get(i).get(j);
                array.get(i).set(temp, j);
                temp = swap;
            }
        }

        size++;
    }

    @Override
    public T remove(int index) {
        int arrayToAccess = index / vector;
        int position = index % vector;

        T removed = array.get(arrayToAccess).get(position);
        T swap = array.get(arrayToAccess).get(position + 1);
        array.get(arrayToAccess).set(swap, position);

        for (int i = position + 1; i < vector; i++) {

            if (i == vector - 1) {
                if (arrayToAccess + 1 >= array.size()) {
                    size--;
                    return removed;
                }
                swap = array.get(arrayToAccess + 1).get(0);
            } else {
                swap = array.get(arrayToAccess).get(i + 1);
            }

            array.get(arrayToAccess).set(swap, i);
        }

        for (int i = arrayToAccess + 1; i < array.size(); i++) {
            for (int j = 0; j < vector; j++) {

                if (i * vector + j >= size) {
                    break;
                }

                if (j == vector - 1) {
                    swap = array.get(i + 1).get(0);
                } else {
                    swap = array.get(i).get(j + 1);
                }

                array.get(i).set(swap, j);
            }
        }

        size--;
        return removed;
    }

    @Override
    public void set(T item, int index) {

    }
}
