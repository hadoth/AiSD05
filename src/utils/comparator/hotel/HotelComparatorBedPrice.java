package utils.comparator.hotel;

import hotel.Hotel;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorBedPrice  extends HotelComparator {
    private int bedNumber;

    public HotelComparatorBedPrice(int bedNumber){
        this.bedNumber = bedNumber;
    }

    @Override
    public int compare(Hotel left, Hotel right) {
        Double rightPrice = right.getPrice(this.bedNumber);
        Double leftPrice = left.getPrice(this.bedNumber);
        if (rightPrice == null){
            if (leftPrice == null) return 0;
            else return -1;
        } else {
            if (leftPrice == null) return 1;
            else return leftPrice.compareTo(rightPrice);
        }
    }
}