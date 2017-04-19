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

    private HotelImpl(){};

    private HotelImpl(
            int starRate,
            boolean hasPool,
            boolean hasSpa,
            boolean isConferenceReady,
            double xCoordinate,
            double yCoordinate,
            HashMap<Integer, Double> bedPrices
    ){
        this.starRate = starRate;
        this.userRateSum = 0;
        this.userRateNumber = 0;
        this.hasPool= hasPool;
        this.hasSpa = hasSpa;
        this.isConferenceReady = isConferenceReady;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.bedPrices = new HashMap<>();
        for (Integer bedNumber : bedPrices.keySet()){
            this.bedPrices.put(bedNumber, bedPrices.get(bedNumber));
        }
    }

    @Override
    public int getStars() {
        return this.starRate;
    }

    @Override
    public double getUserRating() {
        return (1.0*this.userRateSum)/this.userRateNumber;
    }

    @Override
    public boolean hasPool() {
        return this.hasPool;
    }

    @Override
    public boolean hasSpa() {
        return this.hasSpa;
    }

    @Override
    public boolean isConferenceReady() {
        return this.isConferenceReady;
    }

    @Override
    public double getDistanceFrom(double xCoordinate, double yCoordinate) {
        return 0;
    }

    @Override
    public double getPrice(int bedNumber) {
        return this.bedPrices.get(bedNumber);
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
