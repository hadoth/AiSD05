package utils.comparator.hotel;

import hotel.Hotel;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorUserRating implements HotelComparator {

    @Override
    public int compare(Hotel left, Hotel right) {
        Double leftRating = left.getUserRating();
        Double rightRating = right.getUserRating();
        return leftRating.compareTo(rightRating);
    }
}
