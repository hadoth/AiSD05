package utils.comparator.hotel;

import hotel.Hotel;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorSpa extends HotelComparator {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Boolean.valueOf(left.hasSpa()).compareTo(right.hasSpa());
    }
}
