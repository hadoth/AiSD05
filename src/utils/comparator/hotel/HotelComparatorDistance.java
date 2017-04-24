package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorDistance  implements Comparator<Hotel> {
    private double xCoordinate;
    private double yCoordinate;

    public HotelComparatorDistance(double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public int compare(Hotel left, Hotel right) {
        Double leftDistance = left.getDistanceFrom(this.xCoordinate, this.yCoordinate);
        Double rightDistance = right.getDistanceFrom(this.xCoordinate, this.yCoordinate);
        return leftDistance.compareTo(rightDistance);
    }
}
