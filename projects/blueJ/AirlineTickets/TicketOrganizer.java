import java.util.ArrayList;
import java.util.HashMap;

public class TicketOrganizer{
    private ArrayList<AirlineTicket> tickets;

    public TicketOrganizer(ArrayList<AirlineTicket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<AirlineTicket> getTickets() {  
        return tickets;
    }

    /*
     * I don't think it was part of the description in text, but the example 
     * you showed had the passenger names organized by number; so I tried to do that.
     */
    public void printPassengersByBoardingGroup() {
        /*
         * each arraylist in the hashmap represents a boarding group, where the boarding group number is stored
         * in the key. A hashmap seemed like the best choice because when iterating through each passenger, there
         * is no guarantee that passenger's boarding group exists within the new arraylist's indices. I could've
         * just made space when instantiaiting the arraylist, but I thought it would be better practice to grow the
         * collection as needed, as the boarding groups don't necessarily bind to indices (what if they were letters?).
         */
        HashMap<Integer, ArrayList<AirlineTicket>> sortedTickets = new HashMap<Integer, ArrayList<AirlineTicket>>();
        
        //this checks if the arraylist for a given ticket's boarding group exists yet in the hashmap.
        for (AirlineTicket ticket : tickets) {
            if (sortedTickets.containsKey(ticket.getBoardingGroup())) {
                sortedTickets.get(ticket.getBoardingGroup()).add(ticket);
            } else {
                /*
                 * if it doesn't, make a new entry in the hashmap, the key being the 
                 * boarding group number and the value being a new arraylist, which 
                 * we can then populate with more tickets from the tickets arraylist.
                 */
                sortedTickets.put(ticket.getBoardingGroup(), new ArrayList<>());
                sortedTickets.get(ticket.getBoardingGroup()).add(ticket);
            }
        }
        
        //iterates through the keys in the hashmap
        for (int k : sortedTickets.keySet()) {
            System.out.println("Boarding Group " + k);

            //iterates through all the tickets in each boarding group and prints
            for (AirlineTicket ticket : sortedTickets.get(k)) {
                System.out.println(ticket.getName() + ": Row " + ticket.getRow());
            }
        }
    }

    public void canBoardTogether() {
        int ctr = 0;
        for (int i = 0; i < (tickets.size() - 1); i++) {
            if (tickets.get(i).getBoardingGroup() == tickets.get(i + 1).getBoardingGroup()) {
                if (tickets.get(i).getRow() == tickets.get(i + 1).getRow()) {
                    System.out.println(tickets.get(i).getName() + " can board with " + tickets.get(i + 1).getName() + ".");
                    ctr++;
                }
            }
        }
        
        if (ctr < 1) {
            System.out.println("None.");
        }
        System.out.println();
    }
}