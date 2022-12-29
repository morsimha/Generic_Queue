import java.util.Iterator;

public class MainTickets {
    public static void main(String[] args) {
        CustomersTickets a = new CustomersTickets("Charlie Puth", "276859447", "The coffee was cold!!!!!!!!!!!!!!!!!");
        CustomersTickets b = new CustomersTickets("Agata Christy", "333333333", "Shame!");
        CustomersTickets c = new CustomersTickets("Emily Biton", "111111111", "I went to the zoo and was disappointed");
        CustomersTickets d = new CustomersTickets("Daniel", "276859447", "Very very disappointed");
        CustomersTickets e = new CustomersTickets("Daniel Maman", "276859447", "Very very disappointed");
        CustomersTickets f = new CustomersTickets("Orly David", "222222222", "Shame!");
        CustomersTickets g = new CustomersTickets("Yossi Cohen", "987654321", "The roads in my city are terrible..");
        CustomersTickets h = new CustomersTickets("Emily Biton", "111111111", "I went to the zoo and was disappointed");
        CustomersTickets i2 = new CustomersTickets("Yossi Cohen", "987654321", "The roads in my city are terrible..");
        CustomersTickets j2 = new CustomersTickets("Orly David", "222222222", "The prices are too high!");
        CustomersTickets k = new CustomersTickets("Daniel Maman", "276859447", "Very very VERY disappointed");
        CustomersTickets l = new CustomersTickets("Charlie Puth", "276859447", "The coffee was super cold");
        CustomersTickets m = new CustomersTickets("Charlie Puth", "276859447", "The coffee was cold");
        CustomersTickets mistake = new CustomersTickets("Mr Oops", "000000000", "mistake");

        MyQueue<CustomersTickets> tickets = new MyQueue<CustomersTickets>(7);
        tickets.add(a, 1);
        tickets.add(b, 2);
        tickets.add(c, 5);
        tickets.add(d, 7);
        tickets.add(e, 4);
        tickets.add(f, 2);
        tickets.add(g, 5);
        tickets.add(h, 3);
        tickets.add(i2, 2);
        tickets.add(j2, 1);
        tickets.add(k, 8);
        tickets.add(l, 5);
        tickets.add(m, 1);
        tickets.add(mistake, 5);

        System.out.println("Do we have a mistake? " + tickets.contains(mistake));
        System.out.println("Removing mistake ticket status: " + tickets.remove(mistake));
        System.out.println("Is it still there? " + tickets.contains(mistake));

        CustomersTickets prior = tickets.poll();
        System.out.println("\nThe most prioritize ticket was: " + prior.print());
        System.out.println("Is it still there? " + tickets.contains(prior));

        Iterator<CustomersTickets> it = tickets.iterator();
        System.out.println("\nThis is the queue ordered by priority:");
        int i = 1;
        while (it.hasNext()) {
            CustomersTickets ticket = it.next();

            System.out.println(i + ". " + ticket.print());
            i++;
        }
        it = tickets.iterator();

        Iterator<CustomersTickets> it2 = tickets.iterator();
        int j = 1;
        i = 1;
        while (it.hasNext()) {
            CustomersTickets second = it.next();
            while (it2.hasNext()) {
                CustomersTickets first = it2.next();
                if (first.equals(second) && j>i) {
                   System.out.println("\nTicket number " + i + " is equal to ticket number " + j);
                   System.out.println("First one is id " + first.getID() + ": "+ first.getTicket());
                   System.out.println("Second one is id " + first.getID() + " : "+ first.getTicket());
                }
                i++;
            }
            i = 1;
            j++;
            it2 = tickets.iterator();
        }
        System.out.println("\n### Thanks for using CustomersTickets services!");


    }
}