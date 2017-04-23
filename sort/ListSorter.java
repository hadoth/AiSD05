package sort;

import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-20.
 */
public interface ListSorter<T> {
    List<T> sort (List<T> list);
    String getName();
}
