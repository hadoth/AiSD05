package bootstrap;

import sort.ListSorter;
import sort.SelectSort;
import utils.Benchmark;
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
        ObservableComparator<Integer> observableComparator = new ObservableComparator<>(comparator);

        int counter = 38000;

        List<Integer> listToSort = new ArrayList<>();
        for (int i = 0; i < counter; i++) listToSort.add((int) (Math.random() * 10 * counter));
        ObservableList<Integer> observableList = new ObservableList<>(listToSort);

        observableComparator.addObserver(sorterBenchmark);
        observableList.addObserver(sorterBenchmark);

        System.out.println(Arrays.toString(listToSort.toArray()));

        ListSorter<Integer> sortingAlgorithm = new SelectSort<>(observableComparator);
        sortingAlgorithm.sort(observableList);

        System.out.println(sorterBenchmark.report());
        System.out.println(Arrays.toString(listToSort.toArray()));
    }
}