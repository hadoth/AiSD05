package bootstrap;

import hotel.Hotel;
import hotel.RandomHotelGenerator;

import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-23.
 */
public class ListFiveExTwoTest {
    public static void main(String[] args){
        List<Hotel> myHotels = RandomHotelGenerator.withProcessSource("Book1.csv");
        showList(myHotels);
    }

    public static <T> void showList(List<T> list){
        for (T t : list){
            System.out.println(t.toString());
        }
        System.out.println();
    }
}
