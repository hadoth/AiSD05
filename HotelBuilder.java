import java.util.HashMap;

/**
 * Created by Karol Pokomeda on 2017-04-19.
 */
public class HotelBuilder {
    private int starRate;
    private int userRateSum = 0;
    private int userRateNumber = 0;
    private boolean hasPool = false;
    private boolean hasSpa = false;
    private boolean isConferenceReady = false;
    private double xCoordinate;
    private double yCoordinate;
    private HashMap<Integer, Double> bedPrices = new HashMap<>();

    public HotelBuilder withStarRate(int starRate){
        this.starRate = starRate;
        return this;
    }

    public HotelBuilder withPool(){
        this.hasPool = true;
        return this;
    }

    public HotelBuilder withSpa(){
        this.hasSpa = true;
        return this;
    }

    public HotelBuilder withConferenceRoom(){
        this.isConferenceReady = true;
        return this;
    }

    public HotelBuilder withLocation(double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        return this;
    }

    public HotelBuilder withPriceForBed(int numberOfBeds, double price){
        this.bedPrices.put(numberOfBeds, price);
        return this;
    }
}
