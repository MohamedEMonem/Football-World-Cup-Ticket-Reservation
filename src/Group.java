import java.util.Arrays;

public class Group {
    // int x ,z = (x-1)*(x/2);
    private  static final String dateOfTheStartingMatch = "AT 10PM ON 2022/10/20";
    private  static int day =  21;
    private  static int counter =  0;

    private final String[] teams = new String[4];
    private final Match[] matches = {new Match(),new Match(),new Match(),new Match(),new Match(),new Match()};
    private final City city;
    private final String groupName;

    public Group(City city, String t1, String t2, String t3, String t4, String groupName) {
        this.city = city;
        teams[0] = t1;
        teams[1] = t2;
        teams[2] = t3;
        teams[3] = t4;
        this.groupName = groupName;
        genrateGroupMatches(this.city.getStadiumName(), t1, t2, t3, t4, groupName);
    }

    public String getGroupName() {
        return groupName;
    }

    public String stringTeams() {
        return Arrays.toString(teams);
    }

    @Override
    public String toString() {
        return "Group [city=" + city + ", teams=" + Arrays.toString(teams) + ", groupName=" + groupName + ", matches=" + Arrays.toString(matches) + "]";
    }

    public void genrateGroupMatches(String stadiumName, String t1, String t2, String t3, String t4, String groupName) {
        
        if (groupName.equals("A"))
        {matches[0].setDate(dateOfTheStartingMatch);}
        else
        {matches[0].setDate("AT 6PM ON 2022/10/"+day);}

        matches[0].setGroupName(groupName);
        matches[0].setStadiumName(stadiumName);
        matches[0].setTeam1Name(t1);
        matches[0].setTeam2Name(t2);
        counter++;

        matches[1].setGroupName(groupName);
        matches[1].setStadiumName(stadiumName);
        matches[1].setTeam1Name(t4);
        matches[1].setTeam2Name(t3);
        matches[1].setDate("AT 8PM ON 2022/10/"+day);
        
        day += 4;
        matches[2].setGroupName(groupName);
        matches[2].setStadiumName(stadiumName);
        matches[2].setTeam1Name(t4);
        matches[2].setTeam2Name(t2);
        matches[2].setDate("AT 6PM ON 2022/10/"+day);
        
        matches[3].setGroupName(groupName);
        matches[3].setStadiumName(stadiumName);
        matches[3].setTeam1Name(t1);
        matches[3].setTeam2Name(t3);
        matches[3].setDate("AT 8PM ON 2022/10/"+day);
        
        day += 4;
        matches[4].setGroupName(groupName);
        matches[4].setStadiumName(stadiumName);
        matches[4].setTeam1Name(t1);
        matches[4].setTeam2Name(t4);
        matches[4].setDate("AT 6PM ON 2022/10/"+day);
        
        matches[5].setGroupName(groupName);
        matches[5].setStadiumName(stadiumName);
        matches[5].setTeam1Name(t3);
        matches[5].setTeam2Name(t2);
        matches[5].setDate("AT 8PM ON 2022/10/"+day);
        
        day -=8;
        if(counter % 2 ==0)
        { day++;}
        
    }


    public Match getMatch( int matchNumber ) {
        return matches[matchNumber];
    }


}
