package by.it.kglushchenko.jd01_11;

import java.util.*;


public class SetC<T> implements Set<T> {
    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[0];
    private int size = 0;


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < size; i++) {
            joiner.add(elements[i] == null ? "NULL" : elements[i].toString());
        }
        return joiner.toString();
    }

    @Override
    public boolean add(Object o) {

        if (!contains(o)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = (T) o;
            return true;
        }
        return true;

    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null && elements[i] == null) {
                return true;

            } else if (elements[i] != null && elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this set (its cardinality).  If this
     * set contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this set (its cardinality)
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @return {@code true} if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o || elements.equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                elements[size] = null;   //for GC
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        int count = 0;
        for (Object o : c) {
            if (contains(o)) {
                remove(o);
                count++;
            }
        }
        return count <= c.size();
    }

    @Override
    public boolean containsAll(Collection c) {
        if (!isEmpty()) {
            for (Object o : c) {
                if (!contains(o)) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public Iterator iterator() {
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
    public boolean retainAll(Collection c) {

        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}
