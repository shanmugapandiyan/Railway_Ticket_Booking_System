package RAIWAY_TICKET_BOOKING_SYSTEM;

import java.util.*;

public class TicketSystem {
    private List<String> availableberth=new ArrayList<>(Arrays.asList("L","M","U"));
    private Queue<Passenger> racqueue=new LinkedList<>();
    private Queue<Passenger>waitingListQueue=new LinkedList<>();
    private List<Passenger>confirmedtickets=new ArrayList<>();
    private int ticketcounter=1;
    public void addbooking(String name,int age,String gender,String berthpreference){
        String ticketId="T"+ticketcounter++;
        if(!availableberth.isEmpty()) {
            String berthalloted = alocateberth(name, age, gender, berthpreference);
            Passenger passenger = new Passenger(name, age, gender,berthpreference,berthalloted,ticketId);
            confirmedtickets.add(passenger);
            availableberth.remove(berthalloted);
            System.out.println("Ticket Confirmed "+passenger);

        } else if (racqueue.size()<1) {
            Passenger passenger=new Passenger(name,age,gender,berthpreference,"RAC",ticketId);
            racqueue.offer(passenger);
            System.out.println("Ticket vooked in RAC :"+passenger);


        } else if (waitingListQueue.size()<1) {
            Passenger passenger=new Passenger(name,age,gender,berthpreference,"WL",ticketId);
            waitingListQueue.offer(passenger);
            System.out.println("Ticket Booked in Wl : "+passenger);

        }
        else {
            System.out.println("no tickets are Available");
        }
    }

    private String alocateberth(String name, int age, String gender, String berthpreference) {
        if(age>=60 && gender.equalsIgnoreCase("female") && availableberth.contains("L")){
            return "L";
        }
        else if(availableberth.contains(berthpreference)){
            return berthpreference;
        }
        else {
            return availableberth.get(0);
        }
    }
    public void cancelTicket(String ticketId){
        Optional<Passenger>optionalPassenger=confirmedtickets.stream().filter(p->p.ticketid.equals(ticketId)).findFirst();
        if(optionalPassenger.isPresent()){
            Passenger p=optionalPassenger.get();
            confirmedtickets.remove(p);
            availableberth.add(p.allotedberth);
            if(!racqueue.isEmpty()){
                Passenger cp=racqueue.poll();
                String alocateberth=alocateberth(cp.name,cp.age,cp.gender,cp.berthpreference);
                cp.allotedberth=alocateberth;
                confirmedtickets.add(cp);
                availableberth.remove(alocateberth);
                System.out.println("ticket Successfully Moved to RAC-CNF "+cp);

            }
            if(!waitingListQueue.isEmpty()){
                Passenger wp=waitingListQueue.poll();
                if(racqueue.isEmpty()){
                    racqueue.offer(wp);
                    System.out.println("ticket Succesfully Moved to Rac"+wp);
                }
            }
        }
        else {
            System.out.println("Ticket Not Found");
        }
    }

    public void viewconfirmedtickets() {
        for(Passenger p:confirmedtickets){
            System.out.println(p);
        }
    }

    public void viewAvailabletickets() {
        System.out.println("Ticket    :   "+availableberth.size());
        System.out.println("RAC Ticket    :   "+(1-racqueue.size()));
        System.out.println("Wl Ticket    :   "+(1-waitingListQueue.size()));
    }

    public void viewRacticket() {
        for(Passenger p:racqueue){
            System.out.println(p);
        }
    }

    public void viewWaitinglistticket() {
        for(Passenger p:waitingListQueue){
            System.out.println(p);
        }
    }
}
