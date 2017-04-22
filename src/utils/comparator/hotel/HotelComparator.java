package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public abstract class HotelComparator implements Comparator<Hotel> {

    @Override
    public abstract int compare(Hotel left, Hotel right);
}
