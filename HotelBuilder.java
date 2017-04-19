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
}
