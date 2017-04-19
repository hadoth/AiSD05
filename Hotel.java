/**
 * Created by Karol Pokomeda on 2017-04-13.
 */
public interface Hotel extends Comparable<Hotel> {
    int getStars();
    double getUserRating();
    boolean hasPool();
    boolean hasSpa();
    boolean isConferenceReady();
    double  getDistanceFrom(double xCoordinate, double yCoordinate);
    double getPrice(int bedNumber);
}
