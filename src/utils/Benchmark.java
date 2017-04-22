package utils;

import utils.observer.Observable;
import utils.observer.Observer;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class Benchmark implements Observer {
    private int compareCounter;
    private int compareMilCounter;
    private int changeCounter;
    private int changeMilCounter;

    public Benchmark(){

        this.compareCounter = 0;
        this.compareMilCounter = 0;
        this.changeCounter = 0;
        this.changeMilCounter = 0;
    }

    @Override
    public void update(Observable.SortingEvent event){
        if (!event.equals(Observable.SortingEvent.COMPARE)) {
            this.changeCounter++;
            if (this.changeCounter%2000000 == 0) {
                this.changeCounter = 0;
                System.out.println(++this.changeMilCounter + "M changes");
            }
        }
        if (event.equals(Observable.SortingEvent.COMPARE)){
            this.compareCounter++;
            if (this.compareCounter%1000000 == 0) {
                this.compareCounter = 0;
                System.out.println(++this.compareMilCounter + "M compares");
            }
        }
    }

    public String report(){
//        System.out.println();
//        System.out.println(this.compareCounter);
//        System.out.println(this.compareMilCounter);
//        System.out.println(this.changeCounter);
//        System.out.println(this.changeMilCounter);
//        System.out.println();

        return "number of swaps:\t\t" + this.concatenate(this.changeMilCounter, this.changeCounter/2)+
                "\nnumber of comparisons:\t" + this.concatenate(this.compareMilCounter, this.compareCounter);
    }

    private String concatenate(int milPart, int rest){
        if (milPart == 0) return String.valueOf(rest);
        String result = String.valueOf(milPart);
        for (int i = String.valueOf(rest).length(); i < 7; i++) result += "0";
        return result + rest;
    }
}
