public class FootballTeam extends Team{
    private int goalsFor;
    private int goalsAgainst;

    public FootballTeam(String teamName, int numOfPlayers) {
        super(teamName, numOfPlayers);
        teamScore = 0;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
        setTeamScore();
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
        setTeamScore();
    }

    //Decide rank on the basis of difference of Goals;
    @Override
    protected void setTeamScore(){
        teamScore = (int)Math.pow(goalsFor-goalsAgainst, 2);
    }
}
