package ohm.softa.a04;

import java.util.Comparator;
import java.util.Iterator;

public abstract class CollectionsUtility {

    private CollectionsUtility() {
    }

    public static <T> SimpleList<T> sort(SimpleList<T> list, Comparator<T> comparator) {
        if (list.size() == 1) {
            return list;
        }
        SimpleList<T> left = new SimpleListImpl<>();
        Iterator<T> iterator = list.iterator();
        for (int i = 0; i < list.size() / 2; i++) {
            left.add(iterator.next());
        }
        SimpleList<T> right = new SimpleListImpl<>();
        while (iterator.hasNext()) {
            right.add(iterator.next());
        }
        return merge(sort(left, comparator), sort(right, comparator), comparator);
    }

    private static <T> SimpleList<T> merge(SimpleList<T> left, SimpleList<T> right, Comparator<T> comparator) {
        if (left.size() == 0) {
            return right;
        }
        if (right.size() == 0) {
            return left;
        }
        SimpleList<T> mergeList = new SimpleListImpl<>();
        Iterator<T> leftIt = left.iterator();
        Iterator<T> rightIt = right.iterator();
        T leftElem = leftIt.next();
        T rightElem = rightIt.next();

        do {
            if (rightElem != null) {
                int v = comparator.compare(leftElem, rightElem);
                if (v <= 0) {
                    mergeList.add(rightElem);
                    rightElem = rightIt.next();
                } else {
                    mergeList.add(leftElem);
                    leftElem = leftIt.next();
                }
            } else {
                mergeList.add(leftElem);
                leftElem = leftIt.next();
            }
        } while (leftIt.hasNext());
        if (rightIt.hasNext()) {

            while (rightIt.hasNext()) {
                mergeList.add(rightElem);
                rightElem = rightIt.next();
            }
        }
        return mergeList;
    }
}
