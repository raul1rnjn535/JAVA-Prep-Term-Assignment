public class CricketTeam extends Team {
    private int matchesWon;
    private int matchesLost;
    private int seriesWon;
    private int seriesLost;

    public CricketTeam(String teamName, int numOfPlayers) {
        super(teamName, numOfPlayers);
        this.matchesWon = 0;
        this.matchesLost = 0;
        this.seriesWon = 0;
        this.seriesLost = 0;
        teamScore = 0;
    }

    public void incMatchesWon() {
        this.matchesWon++;
        setTeamScore();
    }

    public void incMatchesLost() {
        this.matchesLost++;
        setTeamScore();
    }

    public void incSeriesWon() {
        this.seriesWon++;
        setTeamScore();
    }

    public void incSeriesLost() {
        this.seriesLost++;
        setTeamScore();
    }

    @Override
    protected void setTeamScore() {
        teamScore = (seriesWon - seriesLost)*5 + (matchesWon - matchesLost)*2;
    }

}
