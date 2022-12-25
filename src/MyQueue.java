import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 1;

            @Override
            public boolean hasNext() {
                for (int i = currentIndex; i <= maxPriority; i++) {
                    try {
                        return q.get(currentIndex).iterator().hasNext();
                    }
                    catch (Exception e){
                        continue;
                    }
//                    if (q.get(currentIndex).iterator().hasNext())
//                        return true;
                }
                return false;
            }

            @Override
            public T next() {
                for (int i = currentIndex; i <= maxPriority; i++) {
                    try {
                        return q.get(currentIndex).iterator().next();
                    }
                    catch (Exception e){
                        continue;
                    }
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }





//
//    @Override
//    public Iterator<T> iterator() {
//        return new MyQueueIterator();
//    }
//
//    public class MyQueueIterator <T>  implements Iterator<T> {
//        private int listIndex;
//        private Iterator<T> listIterator;
//
//        public MyQueueIterator() {
//            listIndex = 0;
//            listIterator = q.get(listIndex).iterator();
//        }
//        @Override
//        public boolean hasNext() {
//            return q.get(listIndex).iterator();
//        }
//
//        @Override
//        public T next() {
//            return null;
//        }
//    }

public static void main (String[]args){
        System.out.println("Hello world!");
    MyQueue<String> q = new MyQueue<String>(10);


    q.add("High priority element",5);
    q.add( "High priority element2",1);
    System.out.println(q.size());
    Iterator<String> it = q.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }





    }
//
//        public Queue<T> getQ () {
//            return q;
//        }
//
//        public void setQ (Queue < T > q) {
//            this.q = q;
//        }
//
//        public int getPriority () {
//            return maxPriority;
//        }
//
//        public void setPriority ( int priority){
//            maxPriority = priority;
//        }

//    public static <E extends Reducable <E>>ArrayList<E> reduceAll(ArrayList<E> a){
//        return a;
//    }
}