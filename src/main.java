import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        MyQueue<String> q = new MyQueue<String>(9);

        q.add("first", 1);
        q.add("second", 1);
        q.add("fourth", 5);
        q.add("last", 10);
        q.add("fifth", 5);
        q.add("third", 2);

        System.out.println("Initial size is " + q.size());
        System.out.println("current content is: ");
        Iterator<String> it = q.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\nDo we have \"first\" in the queue? " + q.contains("first"));
        System.out.println("Do we have \"last\" in the queue? " + q.contains("last"));

        System.out.println("Polling the most prior item called: " + q.poll());
        System.out.println("Removing \"last\" status... " + q.remove("last"));

        it = q.iterator();
        System.out.println("\nnow the queue size is "+ q.size() +" and the content is: ");
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println("\nDo we have \"first\" in the queue now? " + q.contains("first"));
        System.out.println("Do we have \"last\" in the queue? " + q.contains("last"));
        System.out.println("\nLets add some jokers. This is the queue now:");

        q.add("joker", 6);
        q.add("joker", 3);
        it = q.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\nDo we have \"joker\" in the queue? " + q.contains("joker"));
        System.out.println("Removing first joker:");
        System.out.println("Removing status... " + q.remove("joker"));
        System.out.println("\nDo we still have \"joker\" in the queue? " + q.contains("joker"));
        System.out.println("Removing second joker:");
        System.out.println("Removing status... " + q.remove("joker"));
        System.out.println("\nDo we still have \"joker\" in the queue? " + q.contains("joker"));
        System.out.println("Trying to remove another joker anyway:");
        System.out.println("Removing status... " + q.remove("joker"));

        System.out.println("\nThis is the queue content now:");
        it = q.iterator();
        while (it.hasNext())
            System.out.println(it.next());

    }
}