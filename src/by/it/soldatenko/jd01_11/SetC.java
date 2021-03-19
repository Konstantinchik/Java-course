package by.it.soldatenko.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        if(!contains(t)) {
            elements[size++] = t;
            System.out.println(size);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == (T) o){return true;}
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
