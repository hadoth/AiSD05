package utils.list;

import utils.observer.Observable;
import utils.observer.Observer;


/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class ObservableList<T> extends SwapList implements Observable {
    private MyList<Observer> observerList;

    public ObservableList(MyList<T> internalList){
        super(internalList);
        this.observerList = new MyList<>();
    }

    public void swap(int indexLeft, int indexRight){
        super.swap(indexLeft, indexRight);
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
}
