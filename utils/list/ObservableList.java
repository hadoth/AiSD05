package utils.list;

import utils.observer.Observable;
import utils.observer.Observer;


/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class ObservableList<T> implements Observable, ListInterface<T> {
    private MyList<T> internalList;
    private MyList<Observer> observerList;

    public ObservableList(MyList<T> internalList){
        this.internalList = internalList;
        this.observerList = new MyList<>();
    }

    public void swap(int indexLeft, int indexRight){
        T temp = this.internalList.get(indexLeft);
        this.internalList.set(this.internalList.get(indexRight), indexLeft);
        this.internalList.set(temp, indexRight);
        this.notifyObservers(SortingEvent.SWAP);
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
        while (!observers.isDone()){
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
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return this.internalList.get(index);
    }

    @Override
    public T set(T t, int index) throws IndexOutOfBoundsException {
        return this.internalList.set(t, index);
    }

    @Override
    public void add(T t) {
        this.internalList.add(t);
    }

    @Override
    public T delete(T t) throws IndexOutOfBoundsException {
        return this.internalList.delete(t);
    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        return this.internalList.delete(index);
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
