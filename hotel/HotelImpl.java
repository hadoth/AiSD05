package hotel;

import java.util.HashMap;

/**
 * Created by Karol Pokomeda on 2017-04-19.
 */
public class HotelImpl implements Hotel {
    private String name;
    private String address; //TODO: address could be refactored to Address class
    private int starRate;
    private int userRateSum;
    private int userRateNumber;
    private boolean hasPool;
    private boolean hasSpa;
    private boolean isConferenceReady;
    private double xCoordinate;
    private double yCoordinate;
    private HashMap<Integer, Double> bedPrices;
    // Money saved as double only for purpouses of this exercise
    // Very risky in any production code

    private HotelImpl(){};

    public HotelImpl(
            String name,
            String address,
            int starRate,
            boolean hasPool,
            boolean hasSpa,
            boolean isConferenceReady,
            double xCoordinate,
            double yCoordinate,
            HashMap<Integer, Double> bedPrices
    ){
        this.name = name;
        this.address = address;
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
        double radXCoord1 = Math.toRadians(this.xCoordinate);
        double radXcoord2 = Math.toRadians(xCoordinate);
        double deltaRadX = Math.toRadians(xCoordinate - this.xCoordinate);
        double deltaRadY = Math.toRadians(yCoordinate - this.yCoordinate);
        double a = Math.sin(deltaRadX/2) * Math.sin(deltaRadX/2) +
                Math.cos(radXCoord1) * Math.cos(radXcoord2) *
                Math.sin(deltaRadY/2) * Math.sin(deltaRadY/2); //http://www.movable-type.co.uk/
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = 6371*c;
        return d;
    }

    @Override
    public double getPrice(int bedNumber) {
        return this.bedPrices.get(bedNumber);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public int compareTo(Hotel otherHotel) {
        int result;
        if ((result = this.name.compareTo(otherHotel.getName())) != 0) return result;
        else return this.address.compareTo(otherHotel.getAddress());
    }

    public void rate(int rating){
        this.userRateSum += rating;
        this.userRateNumber ++;
    }
    public static HotelBuilder build(){
        return new HotelBuilder();
    }

    public String toString(){
        return this.name + "; " +
                this.address + "; " +
                this.starRate + ";" +
                this.getUserRating() + ";" +
                this.hasPool + ";" +
                this.hasSpa + ";" +
                this.isConferenceReady + ";" +
                this.xCoordinate + ";" +
                this.yCoordinate + ";" +
                this.bedPrices.toString() + ";";
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
        private String name;
        private String address;

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

        public HotelBuilder withName(String name){
            this.name = name;
            return this;
        }

        public HotelBuilder withAddress(String address){
            this.address = address;
            return this;
        }

        public HotelImpl build(){
            return new HotelImpl(
                    this.name,
                    this.address,
                    this.starRate,
                    this.hasPool,
                    this.hasSpa,
                    this.isConferenceReady,
                    this.xCoordinate,
                    this.yCoordinate,
                    this.bedPrices
            );
        }
    }
}
