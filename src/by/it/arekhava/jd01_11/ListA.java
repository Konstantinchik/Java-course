package by.it.arekhava.jd01_11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ListA<E> implements List<E> {
private E[] elements= (E[]) new Object[0];
private int size=0;

   @Override
    public boolean add(E e) {
       if(size== elements.length){
           elements=Arrays.copyOf(elements,elements.length*3/2+1);
       }
       elements[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E remove(int index) {
       //111 222 333 44 5 null null null//size=5 length=8 index=2
        E element=elements[index];
        System.arraycopy(elements, index+1, elements, index,size-index-1);
        size--;
        elements[size]=null; //for GC
        return element;
    }
    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
       StringJoiner joiner=new StringJoiner(", ", "[","]");
        for (int i = 0; i < size; i++) {
            joiner.add(elements[i].toString());

        }
        return joiner.toString();
    }
//stubs
    @Override
    public boolean addAll(Collection<? extends E> c) {
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
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

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
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }



    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public void clear() {

    }


    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

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
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }
}
