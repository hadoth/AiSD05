package sort;

import utils.comparator.Comparator;
import utils.list.MyList;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class InsertSort<T> implements ListSorter<T> {
    private Comparator<T> comparator;

    public InsertSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    @Override
    public MyList<T> sort(MyList<T> list) {
        return null;
    }
}
