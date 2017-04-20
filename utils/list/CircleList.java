package utils.list;

/**
 * Created by Karol Pokomeda on 2017-03-26.
 */
public class CircleList<T> implements ListInterface<T> {
    private Element<T> head;
    private int size;

    @Override
    public IteratorInterface<T> iterator() {
        return new ListIterator(this);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void insert(T t, int index) throws IndexOutOfBoundsException {
        if (index > 0){
            Element<T> previousElement = head;
            while(index-- > 1) previousElement = previousElement.getNext();
            Element<T> currentElement = new Element<>(t);
            currentElement.setNext(previousElement.getNext());
            previousElement.setNext(currentElement);
        } else {
            Element<T> second = this.head;
            Element<T> first = new Element<>(t);
            first.setNext(second);
            this.head = first;
        }
        this.size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        Element<T> currentElement = head;
        while (index-- > 0) currentElement = currentElement.getNext();
        return currentElement.getCurrent();
    }

    @Override
    public T set(T t, int index) throws IndexOutOfBoundsException {
        Element<T> currentElement = head;
        while (index-- > 0) currentElement = currentElement.getNext();
        T result = currentElement.getCurrent();
        currentElement.setCurrent(t);
        return result;
    }

    @Override
    public void add(T t) {
        Element<T> newElement = new Element<>(t);
        if (this.head != null){
            Element<T> current = this.head;
            while(current.next != this.head) current = current.getNext();
            current.setNext(newElement);
            newElement.setNext(this.head);
        } else {
            this.head = newElement;
        }
        newElement.setNext(this.head);
        this.size++;
    }

    @Override
    public T delete(T t) throws IndexOutOfBoundsException {
        return this.delete(this.indexOf(t));
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Object not found or index exceeds data structure bounds");
        T result = this.get(index);
        if (index > 0){
            Element<T> previousElement = head;
            while(index-- > 1) previousElement = previousElement.getNext();
            Element<T> nextElement = previousElement.getNext().getNext();
            previousElement.setNext(nextElement);
        } else {
            this.head = this.head.getNext();
        }
        this.size--;
        return result;
    }

    @Override
    public boolean contains(T t) {
        Element<T> currentElement = head;
        while (currentElement != null) {
            if (currentElement.getCurrent().equals(t)) return true;
            currentElement = currentElement.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(T t) {
        Element<T> currentElement = head;
        int index = 0;
        while (currentElement != null) {
            if (currentElement.getCurrent().equals(t)) return index;
            currentElement = currentElement.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    private final class Element<T> {
        private T current;
        private Element<T> next;

        Element(T t){
            this.current = t;
            this.next = null;
        }

        Element<T> getNext() {
            return next;
        }

        T getCurrent() {
            return current;
        }

        void setNext(Element<T> next) {
            this.next = next;
        }

        void setCurrent(T current) {
            this.current = current;
        }
    }

    private final class ListIterator implements IteratorInterface<T>{
        private Element<T> focused;
        private int focusedIndex;
        private CircleList<T> internalList;

        public ListIterator(CircleList internalList){
            this.internalList = internalList;
        }

        @Override
        public void first() {
            this.focused = this.internalList.head;
            this.focusedIndex = 0;
        }

        @Override
        public void last() {
            this.focused = this.internalList.head;
            while (!this.focused.getNext().equals(this.internalList.head)) this.focused = this.focused.getNext();
            focusedIndex = this.internalList.size-1;
        }

        @Override
        public void next() {
            this.focused = this.focused.getNext();
            this.focusedIndex++;
            if (this.focusedIndex >= this.internalList.size)
                this.focusedIndex = this.focusedIndex - this.internalList.size;
        }

        @Override
        public void previous() {
            this.focusedIndex--;
            if (this.focusedIndex == -1) this.last();
            else {
                Element<T> lookFor = this.focused;
                while (!this.focused.getNext().equals(lookFor)) this.focused = this.focused.getNext();
            }
        }

        @Override
        public boolean isDone() {
            return this.internalList.isEmpty();
        }

        @Override
        public T current() throws IndexOutOfBoundsException {
            return focused.getCurrent();
        }

        @Override
        public boolean addCurrent(T t) throws IndexOutOfBoundsException {
            this.previous();
            Element<T> newElement = new Element<>(t);
            newElement.setNext(this.focused.getNext());
            this.focused.setNext(newElement);
            this.internalList.size++;
            return true;
        }

        @Override
        public boolean addNext(T t) throws IndexOutOfBoundsException {
            Element<T> newElement = new Element<>(t);
            newElement.setNext(this.focused.getNext());
            this.focused.setNext(newElement);
            this.internalList.size++;
            return true;
        }

        @Override
        public boolean deleteCurrent() throws IndexOutOfBoundsException {
            Element<T> next = this.focused.getNext();
            int deletedIndex = this.focusedIndex;
            this.previous();
            this.focused.setNext(next);
            this.internalList.size--;
            if (deletedIndex == 0){
                this.internalList.head = next;
                this.focusedIndex--;
            }
            this.next();
            return true;
        }
    }
}
