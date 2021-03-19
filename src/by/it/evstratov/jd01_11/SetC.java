package by.it.evstratov.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public int size() {
        return size;
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
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        if(!isEmpty()){
            if(o == null || o.toString().equals("null")){
                for (int i = 0; i < size; i++) {
                    if(elements[i] == null || elements[i] == "null"){
                        result = true;
                        break;
                    }
                }
            }else{
                for (int i = 0; i < size; i++) {
                    if(elements[i] != null){
                        if(elements[i].equals(o)){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean add(E e) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,(size * 3)/2+1);
        }
        if(!contains(e)){
            elements[size++] = e;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if(contains(o)){
            int index = 0;

            for (int i = 0; i < size; i++) {
                if(elements[i] == null){
                    if(elements[i] == o){
                        index = i;
                    }
                }else{
                    if(elements[i].equals(o)){
                        index = i;
                    }
                }
            }
            System.arraycopy(elements,index + 1,elements, index, size - index - 1);
            size--;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;
        for (E e : collection){
            if (add(e)) modified = true;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean modified = true;
        for (Object o : collection) {
            if(!contains(o)){
                modified = false;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object o : collection) {
            if(contains(o)){
                remove(o);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (E element : elements) {
            remove(element);
        }
        size = 0;
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
    public boolean retainAll(Collection<?> collection) {
        return false;
    }
}
