package utils.list;

import utils.observer.Observable;
import utils.observer.Observer;

import java.util.*;


/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class ObservableList<T> implements Observable, List<T> {
    private ArrayList<Observer> observerList;
    private List<T> internalList;

    public ObservableList(List<T> internalList) {
        this.observerList = new ArrayList<>();
        this.internalList = internalList;
    }

    @Override
    public boolean addObserver(Observer observer) {
        return this.observerList.add(observer);
    }

    @Override
    public boolean deleteObserver(Observer observer) {
        this.observerList.remove(this.observerList.indexOf(observer));
        return true;
    }

    @Override
    public void notifyObservers(SortingEvent event) {
        for (Observer observer : this.observerList) observer.notify();
    }

    @Override
    public Object[] toArray() {
        return this.internalList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.internalList.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return this.internalList.add(t);
    }

    @Override
    public int size() {
        return this.internalList.size();
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return this.internalList.get(index);
    }

    @Override
    public T set(int index, T element) {
        return this.internalList.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        this.internalList.add(index, element);
    }

    @Override
    public T remove(int index) {
        return this.internalList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.internalList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.internalList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.internalList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return this.internalList.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        ObservableList<T> result = new ObservableList<T>(this.internalList.subList(fromIndex, toIndex));
        for (Observer observer : this.observerList) result.addObserver(observer);
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return this.internalList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.internalList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.internalList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return this.internalList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.internalList.retainAll(c);
    }

    @Override
    public boolean isEmpty() {
        return this.internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.internalList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.internalList.iterator();
    }

    @Override
    public void clear() {
        this.internalList.clear();
    }
}