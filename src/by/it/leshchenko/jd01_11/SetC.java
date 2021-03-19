package by.it.leshchenko.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[]{};
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
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        if (!contains(e)) {
            elements[size++] = e;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null || elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                elements[size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (elements[i] == null) {
                    return true;
                }
            } else if (elements[i] != null && elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object o : c) {
            if (contains(o)) {
                remove(o);
                if (!result) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    // stubs

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
