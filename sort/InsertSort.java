package sort;

import utils.comparator.Comparator;

import java.util.List;

/**
 * Created by Karol Pokomeda on 2017-04-22.
 */
public class InsertSort<T> implements ListSorter<T> {
    private Comparator<T> comparator;

    public InsertSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> list) {
        List<T> temp = list.subList(0, list.size()-1);
        list.clear();
        while (temp.size() > 0) {
            insertInOrder(list, temp.remove(0),comparator);
            System.out.println();
        }
        return list;
    }

    private static <T> void insertInOrder(List<T> list, T t, Comparator<T> comparator){
        for (int i = 0; i < list.size(); i++){
            if (comparator.compare(t, list.get(i)) >= 0){
                list.add(i, t);
                return;
            }
        }
        list.add(t);
    }
}