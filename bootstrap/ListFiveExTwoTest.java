package bootstrap;

import hotel.Hotel;
import hotel.RandomHotelGenerator;
import sort.BubbleSort;
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

        bubbleSort.setComparator(
                HotelComparator.builder()
                    .withUserRatingaComparator()
//                    .withStarsComparator()
//                    .withConferenceComparator()
                    .build()
        );

        myHotels = bubbleSort.sort(myHotels);

        showList(myHotels);
    }

    public static <T> void showList(List<T> list){
        for (T t : list){
            System.out.println(t.toString());
        }
        System.out.println();
    }
}
