package practice.collections.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private Item<T> first = null;

    private Item<T> last = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (o.equals(current.getElement())) {
                return true;
            }
            current = current.getNext();
            if (current == null) return false;
        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        final T[] objects = (T[]) new Object[size()];
        int i = 0;
        for (T item : this) {
            objects[i] = item;
            i++;
        }
        return objects;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        if (a.length < size()) {
            a = Arrays.copyOf(a, size, (Class<? extends T1[]>) a.getClass());
        }

        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            a[i] = (T1) current.element;
            current = current.getNext();
        }
        return a;
        // END
    }

    @Override
    public boolean add(final T t) {
        // BEGIN (write your solution here)
        if (last == null || first == null) {
            Item<T> item = new Item<T>(t, null, null);
            last = item;
            first = item;
            size++;
            return true;
        }
        Item<T> item = new Item<T>(t, last, null);
        last.next = item;
        last = item;
        size++;
        return true;
        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        if (this.isEmpty()) {
            return false;
        }
        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (o.equals(current.getElement())) {
                if (i == 0) {
                    current = first;
                    Item<T> next = current.getNext();
                    if (next != null) {
                        next.prev = null;
                    }
                    first = next;
                    size--;
                    return true;
                }
                if (i == size() - 1) {
                    current = last;
                    Item<T> prev = current.getPrev();
                    prev.next = null;
                    last = prev;
                    size--;
                    return true;
                }
                Item<T> prev = current.getPrev();
                Item<T> next = current.getNext();
                prev.next = next;
                next.prev = prev;
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        size = 0;
        first = null;
        last = null;
        // END
    }

    @Override
    public T remove(final int index) {
        // BEGIN (write your solution here)
        if (this.isEmpty()) {
            return null;
        }
        if (index >= size()) {
            return null;
        }
        if (index == 0) {
            Item<T> current = first;
            Item<T> next = current.getNext();
            next.prev = null;
            first = next;
            size--;
            return current.element;
        }
        if (index == size() - 1) {
            Item<T> current = last;
            Item<T> prev = current.getPrev();
            prev.next = null;
            last = prev;
            size--;
            return current.element;
        }
        Item<T> current = first.getNext();
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                Item<T> prev = current.getPrev();
                Item<T> next = current.getNext();
                prev.next = next;
                next.prev = prev;
                size--;
                return current.element;
            }
            current = current.getNext();
        }
        return null;
        // END
    }

    // BEGIN (write your solution here)

    // END
    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object target) {
        // BEGIN (write your solution here)
        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (current.element.equals(target)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        if (index > size()) {
            return null;
        }
        Item<T> current = first;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                current.element = element;
                return current.element;
            }
            current = current.getNext();
        }
        return null;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
        if (index > size()) {
            return null;
        }
        Item<T> current = first;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return current.element;
            }
            current = current.getNext();
        }
        return null;
        // END
    }

    // BEGIN (write your solution here)

    // END

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;

        private Item<T> last;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("" + index);
            }
            if (index == size - 1) {
                current = LinkedList.this.last;
            }
            current = LinkedList.this.first;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    break;
                }
                current = current.getNext();
            }
            // END
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            if (size() == 0) {
                throw new NoSuchElementException();
            }
            last = current;
            current = current.next;
            return last.element;
            // END
        }

        @Override
        public void add(final T element) {
            LinkedList.this.add(element);
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)
            if (last == null) {
                throw new IllegalStateException();
            }
            last.element = element;
            // END
        }

        @Override
        public int previousIndex() {
            // BEGIN (write your solution here)
            if (LinkedList.this.isEmpty()) {
                return -1;
            }
            Item<T> current = LinkedList.this.last;
            for (int i = size() - 1; i >= 0; i--) {
                if (current.element.equals(last.element)) {
                    return i;
                }
                current = current.getNext();
            }
            return -1;
            // END
        }

        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            if (!hasNext()) {
                return -1;
            }
            return indexOf(current.getNext());
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            if (current == null) {
                return false;
            }
            return current.prev != null;
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            if (LinkedList.this.isEmpty()/*!hasPrevious()*/) {
                throw new NoSuchElementException();
            }
            if (current != null) {
                last = current;
                current = current.getPrev();
            }
            return last.element;
            // END
        }

        @Override
        public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }
            if (LinkedList.this.remove(last.element)) {
                last = null;
            }
            // END
        }

    }

    private static class Item<T> {

        private T element;

        private Item<T> next;

        private Item<T> prev;

        public Item(final T element, final Item<T> prev, final Item<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrev() {
            return prev;
        }

    }

}
