package bootstrap;

import sort.*;
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
        String[] filePath = {
                "ALMOST_SORTED_1000_ASCENDING.csv",
                "ALMOST_SORTED_1000_DESCENDING.csv",
                "CONST_1000_ASCENDING.csv",
                "CONST_1000_DESCENDING.csv",
                "FULLY_RANDOM_1000_ASCENDING.csv",
                "FULLY_RANDOM_1000_DESCENDING.csv",
                "SORTED_1000_ASCENDING.csv",
                "SORTED_1000_DESCENDING.csv",
                "STAIRS_1000_ASCENDING.csv",
                "STAIRS_1000_DESCENDING.csv"
        };
        NaturalComparator<Integer> comparator = new NaturalComparator<>();

        ArrayList<ListSorter<Integer>> sorters = new ArrayList<>();
        sorters.add(new BubbleSort<>(comparator));
        sorters.add(new SelectSort<>(comparator));
        sorters.add(new InsertSort<>(comparator));
        sorters.add(new ShakerSort<>(comparator));

        Benchmark sorterBenchmark = new Benchmark();

        for (String singleFilePath : filePath) {
            for (ListSorter<Integer> sorter : sorters) {
                sorterBenchmark.evaluate(sorter, comparator, singleFilePath);

                System.out.println(sorterBenchmark.report());
                System.out.println();
            }
        }
    }
}