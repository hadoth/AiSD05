package sort;

import utils.list.MyList;
import utils.list.SwapList;

/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class BubbleSort<T> implements ListSorter<T> {
    private  SwapList<T> internalList;

    public BubbleSort(SwapList<T> swapList){
        this.internalList = swapList;
    }

    @Override
    public MyList<T> sort(MyList<T> list) {
        return null;
    }
}
