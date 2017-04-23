package bootstrap;

import sort.ListSorter;
import sort.ShakerSort;
import utils.comparator.NaturalComparator;

import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-04-23.
 */
public class ListFiveExThreeTest {
    public static void main(String[] args){
        int numberOfElements = 50;

        ArrayList<Integer> listToSort = new ArrayList<>();

        for (int i = 0; i < 50; i++) listToSort.add((int)(Math.random()*numberOfElements));

        ListSorter<Integer> sorter = new ShakerSort<>(new NaturalComparator<>());

        ListFiveExTwoTest.showList(listToSort);

        sorter.sort(listToSort);

        ListFiveExTwoTest.showList(listToSort);
    }
}
