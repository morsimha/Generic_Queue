import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue <T> implements Iterable<T> {
    private final int MAX_PRIORITY = 10;
    private ArrayList<LinkedList<T>> q;
    private int currMaxPriority;


    public MyQueue(int n) {
        currMaxPriority = n;
        q = new ArrayList<LinkedList<T>>();
        q.add(null); //null in index 0 will allow addressing the list naturally with the indexes 1-10.
        for (int i = 1; i <= MAX_PRIORITY; i++) {
            q.add(new LinkedList<>());
        }
    }

    public void add(T t, int currPriority) {
        if (currMaxPriority < currPriority) // invalid priority
            currPriority = currMaxPriority;
        q.get(currPriority).addLast(t); //keeping the first entered always first
    }

    public T poll() {
        T mostPrior = null;
        for (int i = 1; i <= MAX_PRIORITY; i++) {
            mostPrior = q.get(i).poll();
            if (mostPrior != null)
                return mostPrior;
        }
        return mostPrior;
    }

    public boolean contains(T t) {
        for (int i = 1; i <= MAX_PRIORITY; i++)
            if (q.get(i).contains(t))
                return true;
        return false;
    }

    public boolean remove(T element) {
        for (int i = 1; i <= MAX_PRIORITY; i++)
            if (q.get(i).remove(element))
                return true;
        return false;
    }

    public int size() {
        int size = 0;
        for (int i = 1; i <= MAX_PRIORITY; i++) {
            size += q.get(i).size();
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<T> all = new ArrayList<T>();
        for (int i = 1; i <= MAX_PRIORITY; i++)
            all.addAll(q.get(i));
        return all.iterator();
    }
}