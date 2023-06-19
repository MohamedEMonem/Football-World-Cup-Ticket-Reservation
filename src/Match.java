public class Match {
    private String date, team1Name, team2Name, stadiumName, groupName;
    

    public Match() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    @Override
    public String toString() {
        return  "\n" + this.team1Name +" Vs " +
                this.team2Name +
                "\nStadium: " +
                this.stadiumName +
                "\nGroup: " + this.groupName+
                "\nDate: " +
                this.date ;
    }
}