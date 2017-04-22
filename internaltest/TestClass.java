package internaltest;

import sort.BubbleSort;
import sort.ListSorter;
import utils.comparator.NaturalComparator;
import utils.list.IteratorInterface;
import utils.list.MyList;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class TestClass {
    public static void main(String[] args){
        MyList<Integer> testList = new MyList<>();
        for (int i = 0; i < 100; i++) testList.add((int)(Math.random()*1000));

        showList(testList.iterator());

        ListSorter<Integer> sorter = new BubbleSort<>(new NaturalComparator<Integer>());

        SwapList<Integer> listToSort = new SwapList<>(testList);

        listToSort = sorter.sort(listToSort);

        showList(listToSort.iterator());
    }

    /**
     * Static methods which iterates through the data structure and prints data in console
     * @param {IteratorInterface} iterator
     */
    public static void showList(IteratorInterface iterator){
        iterator.first();
        while(!iterator.isDone()){
            System.out.println(iterator.current());
            iterator.next();
        }
    }
}
