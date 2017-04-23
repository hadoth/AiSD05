package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorStars implements Comparator<Hotel> {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Integer.valueOf(left.getStars()).compareTo(right.getStars());
    }
}