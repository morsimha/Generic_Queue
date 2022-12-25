import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue <T>{
    private ArrayList<T> q2;
    private Queue<T> q;
    private int maxPriority;

    public MyQueue(int n){
        q2 = new ArrayList<T>();
        q = new LinkedList<T>();
        maxPriority = n;
    }
    public void add(T t, int newPriority){
        if (newPriority <= maxPriority) // valid priority
            if (q2.get(newPriority) != null){
                //need to push one right
        }
        else // insert as last element
            q2.set(maxPriority,t);
    }

    public void poll(T t, int newPriority){
        if (newPriority <= maxPriority) // valid priority
            q.add(t); //TODO need to add to the correct priority
        else // insert as last element
            q.add(t);
    }










    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public Queue<T> getQ() {
        return q;
    }

    public void setQ(Queue<T> q) {
        this.q = q;
    }

    public int getPriority() {
        return maxPriority;
    }

    public void setPriority(int priority) {
        maxPriority = priority;
    }

//    public static <E extends Reducable <E>>ArrayList<E> reduceAll(ArrayList<E> a){
//        return a;
//    }
}