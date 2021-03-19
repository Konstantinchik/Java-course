package by.it.arekhava.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {
        private E[] elements = (E[]) new Object[0];
        private int size = 0;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

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
        public boolean add(E e) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = e;
            return true;
        }
    @Override
    public void add(int index, E element) {
        if (size == elements.length) {//3 4    90     6 9 32 0    ind=2 e=90
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements,index,elements,index+1, size-index);
        elements[index]=element;
        size++;
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // 4 5 6 7 9 0 E
        //1 2 3 c
        // ind=2
        int countc=c.size();

        if (size == elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }

        if (size - index > 0)
        System.arraycopy(elements, index,elements,index+countc, size-index);
        System.arraycopy(c, 0,elements,index, countc);

        size+=countc;
        return countc != 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
        public boolean remove(Object o) {
            return false;
        }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (size+1 >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + c.size());
        }
        for (E e : c) {
            elements[size] = e;
            size++;
        }
        return true;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
        public E remove(int index) {
            //111 222 333 44 5 null null null//size=5 length=8 index=2
            E element = elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            size--;
            elements[size] = null; //for GC
            return element;
        }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
        public E get(int index) {
            return elements[index];
        }

    @Override
    public E set(int index, E element) {
        E remove=elements[index];
        elements[index]=element;

        return remove;
    }




    @Override
    public String toString() {
        StringJoiner joiner=new StringJoiner(", ", "[","]");
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                joiner.add(null);
            }
            else {
                joiner.add(elements[i].toString());
            }
        }
        return joiner.toString();
    }
    }
