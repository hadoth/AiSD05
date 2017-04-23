package internaltest;

import sort.BubbleSort;
import sort.InsertSort;
import sort.ListSorter;
import utils.comparator.NaturalComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class TestClass {
    public static void main(String[] args){
        List<Integer> listToSort = new ArrayList<>();
        for (int i = 0; i < 100; i++) listToSort.add((int)(Math.random()*1000));

        System.out.println(Arrays.toString(listToSort.toArray()));

        System.out.println();

        ListSorter<Integer> sorter = new BubbleSort<>(new NaturalComparator<Integer>());

        listToSort = sorter.sort(listToSort);

        System.out.println(Arrays.toString(listToSort.toArray()));
    }
}
