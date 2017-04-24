package bootstrap;

import hotel.Hotel;
import hotel.RandomHotelGenerator;
import sort.BubbleSort;
import utils.Benchmark;
import utils.comparator.Comparator;
import utils.comparator.NaturalComparator;
import utils.comparator.hotel.HotelComparator;

import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-23.
 */
public class ListFiveExTwoTest {
    public static void main(String[] args){
        List<Hotel> myHotels = RandomHotelGenerator.withProcessSource("Book1.csv");
        showList(myHotels);

        BubbleSort<Hotel> bubbleSort = new BubbleSort<>(new NaturalComparator<Hotel>());

        myHotels = bubbleSort.sort(myHotels);

        showList(myHotels);

        Comparator<Hotel> compositeComparator = HotelComparator.builder()
                    .withUserRatingaComparator()
                    .withStarsComparator()
                    .withConferenceComparator()
                    .build();

        bubbleSort.setComparator(compositeComparator);

        myHotels = bubbleSort.sort(myHotels);

        Benchmark.assertSorted(myHotels, compositeComparator);

        showList(myHotels);
    }

    public static <T> void showList(List<T> list){
        for (T t : list){
            System.out.println(t.toString());
        }
        System.out.println();
    }
}
