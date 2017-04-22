package sort;

import utils.comparator.Comparator;
import utils.list.SwapList;

/**
 * Created by Karol Pokomeda on 2017-04-21.
 */
public class BubbleSort<T> implements ListSorter<T> {
    private Comparator<T> comparator;

    public BubbleSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    @Override
    public SwapList<T> sort(SwapList<T> list) {
        boolean isSorted  = false;
        int j = 1;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < list.size()-j; i++){
                if (this.comparator.compare(list.get(i), list.get(i+1)) > 0) list.swap(i, i+1);
                isSorted = false;
            }
            j++;
        }
        return list;
    }
}
