package utils;

import utils.observer.Observable;
import utils.observer.Observer;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class Benchmark implements Observer {
    private int compareCounter;
    private int changeCounter;

    public Benchmark(){

        this.compareCounter = 0;
        this.changeCounter = 0;
    }

    @Override
    public void update(Observable.SortingEvent event){
        if (!event.equals(Observable.SortingEvent.COMPARE)) {
            this.changeCounter++;
            if (this.changeCounter%2000000 == 0) System.out.println(this.changeCounter/2000000 + "M changes");
        }
        if (event.equals(Observable.SortingEvent.COMPARE)){
            this.compareCounter++;
            if (this.compareCounter%1000000 == 0) System.out.println(this.compareCounter/1000000 + "M compares");
        }
    }

    public String report(){
        return "number of changes\t" + this.changeCounter/2 + "\nnumber of comparisons:\t" + this.compareCounter;
    }
}
