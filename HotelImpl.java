import java.util.HashMap;

/**
 * Created by Karol Pokomeda on 2017-04-19.
 */
public class HotelImpl implements Hotel {
    private int starRate;
    private int userRateSum;
    private int userRateNumber;
    private boolean hasPool;
    private boolean hasSpa;
    private boolean isConferenceReady;
    private double xCoordinate;
    private double yCoordinate;
    private HashMap<Integer, Double> bedPrices;

    @Override
    public int getStars() {
        return 0;
    }

    @Override
    public double getUserRating() {
        return 0;
    }

    @Override
    public boolean hasPool() {
        return false;
    }

    @Override
    public boolean hasSpa() {
        return false;
    }

    @Override
    public boolean isConferenceReady() {
        return false;
    }

    @Override
    public double getDistanceFrom(double xCoordinate, double yCoordinate) {
        return 0;
    }

    @Override
    public double getPrice(int bedNumber) {
        return 0;
    }

    @Override
    public int compareTo(Hotel o) {
        return 0;
    }

    public static HotelBuilder build(){
        return new HotelBuilder();
    }

    public static class HotelBuilder {
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
}
