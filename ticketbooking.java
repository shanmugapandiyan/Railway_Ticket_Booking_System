package RAIWAY_TICKET_BOOKING_SYSTEM;
import java.util.*;

public class ticketbooking {
    public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            TicketSystem t=new TicketSystem();
            boolean b=true;
            while (b){
                System.out.println("-----------------TRAIN TICKET BOOKING SYSTEM-----------------");
                System.out.println("\n 1. BookTIcket \n 2. Cancel Ticket \n 3.ViewConfiremd Tickets \n 4. View Available Tickets \n 5. View RAC ticket \n 6. View WaitingList Tickets \n 7. Exit");
                int c=in.nextInt();
                in.nextLine();
                switch (c){
                    case 1:
                        System.out.println("ENter Name : " );
                        String name=in.next();
                        System.out.println("Enter age : " );
                        int age=in.nextInt();
                        System.out.println("ENter gender (male/female) : " );
                        String gender=in.next();
                        System.out.println("Enter berth preference  (L/M/U): " );
                        String bf=in.next();

                        t.addbooking(name,age,gender,bf);
                        break;
                    case 2:
                        System.out.println("enter Ticketid");
                        String ticketid= in.next();
                        t.cancelTicket(ticketid);
                        break;
                    case 3:
                        t.viewconfirmedtickets();
                        break;
                    case 4:
                        t.viewAvailabletickets();
                        break;
                    case 5:
                        t.viewRacticket();
                        break;
                    case 6:
                        t.viewWaitinglistticket();
                        break;
                    case 7:
                        b=false;
                        System.out.println("-------------THANK YOU--------------------------");
                        break;
                }
            }
    }
}
