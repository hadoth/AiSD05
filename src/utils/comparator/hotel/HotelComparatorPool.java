package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorPool implements Comparator<Hotel> {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Boolean.valueOf(left.hasPool()).compareTo(right.hasPool());
    }
}