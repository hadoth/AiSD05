package sort;

import utils.list.SwapList;

/**
 * Created by Karol Pokomeda on 2017-04-20.
 */
public interface ListSorter<T> {
    SwapList<T> sort (SwapList<T> list);
}
