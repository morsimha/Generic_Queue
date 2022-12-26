import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue <T> implements Iterable<T> {
    private ArrayList<LinkedList<T>> q;
    private int maxPriority;

    public MyQueue(int n) {
        maxPriority = n;
        q = new ArrayList<LinkedList<T>>(11);
        for (int i = 1; i <= 11; i++) {
            q.add(new LinkedList<>());
        }
    }

    public void add(T t, int currPriority) {
        if (maxPriority < currPriority) // invalid priority
            currPriority = maxPriority;
        q.get(currPriority).addLast(t); //keeping the first entered always first
    }

    public T poll() {
        T mostPrior = null;
        for (int i = 1; i <= 10; i++) {
            mostPrior = q.get(i).poll();
            if (mostPrior != null)
                return mostPrior;
        }
        return mostPrior;
    }

    public boolean contains(T t) {
        for (int i = 1; i <= 10; i++)
            if (q.get(i).contains(t))
                return true;
        return false;
    }

    public boolean remove(T element) {
        for (int i = 1; i <= 10; i++)
            if (q.get(i).remove(element))
                return true;
        return false;
    }

    public int size() {
        int size = 0;
        for (int i = 1; i <= 10; i++) {
            size += q.get(i).size();
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        //QueueIterator it2 = new QueueIterator();
        // it2;
        ArrayList<T> all = new ArrayList<T>();
        for (int i = 1; i <= 10; i++)
            all.addAll(q.get(i));
        return all.iterator();
    }

//    private class QueueIterator implements Iterator<T> {
//        private int currListIndex;
//        private Iterator<T> myQueueIterator;
//        private int lastRet;
//
//        public QueueIterator() {
//            currListIndex = 1;
//            myQueueIterator = q.get(currListIndex).iterator();
//            lastRet = -1; // index of last element returned; -1 if no such
//        }
//
//        @Override
//        public boolean hasNext() {
//            if (myQueueIterator.hasNext()) // if the current Iterator have more items in its linked list.
//                return true;
//            for (int i = currListIndex + 1; i <= 10; i++) { //otherwise, scan the next linked lists.
//                if (!q.get(i).isEmpty()) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        @Override
//        public T next() {
//            if (myQueueIterator.hasNext()) //when the current linked list still have items or first time.
//                return myQueueIterator.next();
//            for (int i = currListIndex + 1; i <= 10; i++) { //otherwise, scan the next linked lists.
//                if (!q.get(i).isEmpty()) {
//                    currListIndex = i;
//                    lastRet = i;
//                    myQueueIterator = q.get(currListIndex).iterator();
//                    return myQueueIterator.next();
//                }
//            }
//            throw new NoSuchElementException();
//        }
//    }
}