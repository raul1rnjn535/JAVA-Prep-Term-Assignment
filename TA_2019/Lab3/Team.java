public abstract class Team {
    protected int teamScore;
    private String teamName;
    private int numOfPlayers;

    public Team(String teamName, int numOfPlayers) {
        this.teamName = teamName;
        this.numOfPlayers = numOfPlayers;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    protected abstract void setTeamScore();

    public int getTeamScore(){
        return teamScore;
    }
}
