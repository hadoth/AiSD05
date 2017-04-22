package utils.comparator.hotel;

import com.sun.org.apache.xpath.internal.operations.Bool;
import hotel.Hotel;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorConference extends HotelComparator {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Boolean.valueOf(left.isConferenceReady()).compareTo(right.isConferenceReady());
    }
}
