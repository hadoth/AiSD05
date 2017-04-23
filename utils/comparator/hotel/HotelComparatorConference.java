package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;


/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorConference implements Comparator<Hotel> {
    @Override
    public int compare(Hotel left, Hotel right) {
        return Boolean.valueOf(left.isConferenceReady()).compareTo(right.isConferenceReady());
    }
}
