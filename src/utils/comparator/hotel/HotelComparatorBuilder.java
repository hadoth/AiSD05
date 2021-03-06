package utils.comparator.hotel;

import hotel.Hotel;
import utils.comparator.Comparator;
import utils.comparator.CompositeComparator;
import utils.comparator.ReverseComparator;

import java.util.ArrayList;

/**
 * Created by Karol on 2017-04-22.
 */
public class HotelComparatorBuilder {
    private ArrayList<Comparator<Hotel>> internalComparators;

    public HotelComparatorBuilder(){
        this.internalComparators = new ArrayList<>();
    }

    public HotelComparatorBuilder withBedPriceComparator(int numberOfBeds){
        this.internalComparators.add(new HotelComparatorBedPrice(numberOfBeds));
        return this;
    }

    public HotelComparatorBuilder withDistanceFromComparator(double xCoordinate, double yCoordinate){
        this.internalComparators.add(new HotelComparatorDistance(xCoordinate, yCoordinate));
        return this;
    }

    public HotelComparatorBuilder withSpaComparator(){
        this.internalComparators.add(new HotelComparatorSpa());
        return this;
    }

    public HotelComparatorBuilder withPoolComparator(){
        this.internalComparators.add(new HotelComparatorPool());
        return this;
    }

    public HotelComparatorBuilder withConferenceComparator(){
        this.internalComparators.add(new HotelComparatorConference());
        return this;
    }

    public HotelComparatorBuilder withStarsComparator(){
        this.internalComparators.add(new HotelComparatorStars());
        return this;
    }

    public HotelComparatorBuilder withUserRatingaComparator(){
        this.internalComparators.add(new HotelComparatorUserRating());
        return this;
    }

    public Comparator<Hotel> build(){
        return new CompositeComparator<Hotel>(this.internalComparators);
    }
}
