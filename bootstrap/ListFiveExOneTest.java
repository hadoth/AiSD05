package bootstrap;

import sort.BubbleSort;
import sort.ListSorter;
import sort.SelectSort;
import utils.Benchmark;
import utils.comparator.Comparator;
import utils.comparator.NaturalComparator;
import utils.comparator.ObservableComparator;
import utils.list.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class ListFiveExOneTest {
    public static void main(String[] args) {
        Benchmark sorterBenchmark = new Benchmark();

        NaturalComparator<Integer> comparator = new NaturalComparator<>();

        int counter = 38000;

        List<Integer> listToSort = new ArrayList<>();
        for (int i = 0; i < counter; i++) listToSort.add((int) (Math.random() * 10 * counter));

        System.out.println(Arrays.toString(listToSort.toArray()));

        sorterBenchmark.evaluate(new BubbleSort<Integer>(comparator), comparator, listToSort);

        System.out.println(sorterBenchmark.report());
        System.out.println(Arrays.toString(listToSort.toArray()));
    }
}