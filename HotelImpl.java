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
}
