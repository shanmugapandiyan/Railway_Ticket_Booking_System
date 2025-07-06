package RAIWAY_TICKET_BOOKING_SYSTEM;

public class Passenger {
    String name;
    int age;
    String gender;
    String berthpreference;
    String allotedberth;
    String ticketid;

    public Passenger(String name, int age, String gender, String berthpreference, String allotedberth, String ticketid) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthpreference = berthpreference;
        this.allotedberth = allotedberth;
        this.ticketid = ticketid;
    }

    @Override
    public String toString() {
        return "ticketId :"+ticketid +" | name  :"+name+"  | age"+age+"  |   Gender"+gender +  "  | allotedbirth   " +allotedberth;
    }
}
