package utils.list;

import utils.observer.Observable;
import utils.observer.Observer;


/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class ObservableList<T> implements Observable, ListInterface<T> {
    private MyList<Observer> observerList;
    private ListInterface<T> internalList;

    public ObservableList(MyList<T> internalList) {
        this.observerList = new MyList<>();
        this.internalList = internalList;
    }

    @Override
    public boolean addObserver(Observer observer) {
        this.observerList.add(observer);
        return true;
    }

    @Override
    public boolean deleteObserver(Observer observer) {
        this.observerList.delete(this.observerList.indexOf(observer));
        return true;
    }

    @Override
    public void notifyObservers(SortingEvent event) {
        IteratorInterface<Observer> observers = this.observerList.iterator();
        observers.first();
        while (!observers.isDone()) {
            observers.current().update(event);
            observers.next();
        }
    }

    @Override
    public IteratorInterface<T> iterator() {
        return this.internalList.iterator();
    }

    @Override
    public int size() {
        return this.internalList.size();
    }

    @Override
    public void insert(T t, int index) throws IndexOutOfBoundsException {
        this.internalList.insert(t, index);
        this.notifyObservers(SortingEvent.CHANGE);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return this.internalList.get(index);
    }

    @Override
    public T set(T t, int index) throws IndexOutOfBoundsException {
        T result = this.internalList.set(t, index);
        this.notifyObservers(SortingEvent.CHANGE);
        return result;
    }

    @Override
    public void add(T t) {
        this.internalList.add(t);
        this.notifyObservers(SortingEvent.CHANGE);
    }

    @Override
    public T delete(T t) throws IndexOutOfBoundsException {
        T result = this.internalList.delete(t);
        this.notifyObservers(SortingEvent.CHANGE);
        return result;
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        T result = this.internalList.delete(index);
        this.notifyObservers(SortingEvent.CHANGE);
        return result;
    }

    @Override
    public boolean contains(T t) {
        return this.internalList.contains(t);
    }

    @Override
    public int indexOf(T t) {
        return this.internalList.indexOf(t);
    }

    @Override
    public boolean isEmpty() {
        return this.internalList.isEmpty();
    }

    @Override
    public void clear() {
        this.internalList.clear();

    }
}