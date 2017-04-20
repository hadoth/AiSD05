package utils.comparator;

/**
 * Created by Karol Pokomeda on 2017-04-20.
 */
public class ObservableComparator<T> implements Comparator<T> {
    private Comparator<T> internalComparator;

    public ObservableComparator(Comparator<T> internalComparator){
        this.internalComparator = internalComparator;
    }

    @Override
    public int compare(T tLeft, T tRight) {
        return 0;
    }
}
