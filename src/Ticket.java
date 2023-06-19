public class Ticket {
    private final Group group;
    private final String category;
    private final int seatNumber;
    private final String area;
    private final Person owner;
    private final int matchNumber;

    public Ticket(Group group, String category, int seatNumber, String area, Person owner,int matchNumber) {
        this.group = group;
        this.category = category;
        this.seatNumber = seatNumber;
        this.area = area;
        this.owner = owner;
        this.matchNumber = matchNumber;

    }


    @Override
    public String toString() {
        return "Ticket Details: " +
                group.getMatch(matchNumber)+
                ",\nCategory: " +
                category + ", \nArea: "
                + area + ",\nSeatNumber: "
                + seatNumber +
                owner ;
    }

}