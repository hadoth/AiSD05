package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorSpa implements Comparator<Hotel> {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Boolean.valueOf(left.hasSpa()).compareTo(right.hasSpa());
    }
}
