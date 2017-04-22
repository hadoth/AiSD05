package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public interface HotelComparator extends Comparator<Hotel> {

    static HotelComparatorBuilder builder(){
        return new HotelComparatorBuilder();
    }
}
