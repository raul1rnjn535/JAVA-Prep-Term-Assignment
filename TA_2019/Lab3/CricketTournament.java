import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CricketTournament extends Tournament{
    private List<CricketTeam> nextRoundTeams;

    public CricketTournament(List<CricketTeam> teamList) {
        super(teamList);
        nextRoundTeams = new ArrayList<>();
    }

    @Override
    void fixtures() {
        for(Team i : teamList){
            nextRoundTeams.add((CricketTeam)i);
        }
    }

    @Override
    Team playTournament() {
        int roundNum = 1;
        while(nextRoundTeams.size() > 1){
            List<CricketTeam> currTeams = new ArrayList<>(nextRoundTeams);
            nextRoundTeams.clear();

            System.out.printf("\tRound %d\n\n", roundNum++);
            int match = 1;
            for(int i = 0; i < currTeams.size(); i+=2){
                CricketTeam team1 = currTeams.get(i);
                CricketTeam team2 = currTeams.get(i+1);
                System.out.printf("\tMatch %d between: %s V/S %s \n", match++, team1.getTeamName(), team2.getTeamName());

                //A Match is played between two teams
                CricketTeam winningTeam = match(team1, team2);
                nextRoundTeams.add(winningTeam);
                System.out.printf("\tWinner: %s\n\n", winningTeam.getTeamName());
            }
        }
        return nextRoundTeams.get(0);
    }


    //Method to conduct match between two teams
    private CricketTeam match(CricketTeam team1, CricketTeam team2){
        Random random = new Random();
        if(random.nextInt(1) == 0){
            team1.incMatchesWon();
            team2.incMatchesLost();
            return team1;
        }
        else{
            team2.incMatchesWon();
            team1.incMatchesLost();
            return team2;
        }
    }


}
