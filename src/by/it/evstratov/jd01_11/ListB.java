package by.it.evstratov.jd01_11;

import java.util.*;

public class ListB<E> implements List<E>{

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E e) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,(size * 3)/2+1);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String del = "";
        for (int i = 0; i < size; i++) {
            stringBuilder.append(del).append(elements[i]);
            del = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public E remove(int index) {
        E element = elements[index];
        System.arraycopy(elements,index + 1,elements, index, size - index - 1);
        size--;
        return element;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int i) {
        return elements[i];
    }

    @Override
    public E set(int i, E e) {
        E element = elements[i];
        elements[i] = e;
        return element;
    }

    @Override
    public void add(int i, E e) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,(size * 3)/2+1);
        }
        if(i == size){
            size++;
            elements[i] = e;
        }else{
            System.arraycopy(elements,i,elements, i+1, size - i);
            elements[i] = e;
            size++;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        String[] col = ((collection.toString()).replaceAll("[{}\\[\\],]","")).split(" ");
        for (String s : col) {
            add((E) s);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

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
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }

}
