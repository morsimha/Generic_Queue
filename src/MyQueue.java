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
        QueueIterator it = new QueueIterator();
        return it;
    }

    private class QueueIterator implements Iterator<T> {
        private int currListIndex;
        private Iterator<T> myQueueIterator;

        public QueueIterator() {
            currListIndex = 1;
            myQueueIterator = q.get(currListIndex).iterator();
        }

        @Override
        public boolean hasNext() {
            if (myQueueIterator.hasNext()) // if the current Iterator have more items in its linked list.
                return true;
            for (int i = currListIndex + 1; i <= 10; i++) { //otherwise, scan the next linked lists.
                if (!q.get(i).isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (myQueueIterator.hasNext()) //when the current linked list still have items or first time.
                return myQueueIterator.next();
            for (int i = currListIndex + 1; i <= 10; i++) { //otherwise, scan the next linked lists.
                if (!q.get(i).isEmpty()) {
                    currListIndex = i;
                    myQueueIterator = q.get(currListIndex).iterator();
                    return myQueueIterator.next();
                }
            }
            throw new NoSuchElementException();
        }
    }


public static void main (String[]args) {
    System.out.println("Hello world!");
    MyQueue<String> q = new MyQueue<String>(10);


    q.add("High priority element fourth", 5);
    q.add("High priority element last_sixth", 10);
    q.add("High priority element fifth", 5);
    q.add("High priority element third", 2);

    System.out.println("size is " + q.size());
    Iterator<String> check = q.iterator();
    System.out.println(check.hasNext());
    System.out.println(check.next());
    System.out.println(check.hasNext());
    System.out.println(check.hasNext());
    System.out.println(check.next());
    System.out.println(check.hasNext());
    System.out.println(check.next());
    System.out.println(check.hasNext()+"\n");

    q.add("High priority element higher_first", 1);
    q.add("High priority element second", 1);



    Iterator<String> it = q.iterator();


    while(it.hasNext())
        System.out.println(it.next());




    ArrayList<String> b = new ArrayList<>(11);
    b.add("hi");
    b.add("bye");
    Iterator<String> it2 = b.iterator();

    System.out.println(it2.hasNext());
    System.out.println(it2.next());
    System.out.println(it2.hasNext());
    System.out.println(it2.next());
    System.out.println(it2.hasNext());


}
}