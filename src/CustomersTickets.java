public class CustomersTickets {
    private String name;
    private String id;
    private String ticket;

    public CustomersTickets(String name, String id, String ticket) {
        this.name = name;
        this.id = id;
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof CustomersTickets) {
            CustomersTickets c = (CustomersTickets) other;
            return c.id.equals(id) && c.ticket.equals(ticket);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;

    }

    public String getTicket() {
        return ticket;
    }

    public String print() {
        return "" + name + ", " +id+ ", " +ticket ;
    }
}

