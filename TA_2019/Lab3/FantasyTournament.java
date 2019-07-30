import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyTournament {

    public static void main(String[] args){
        cricketTournament();
        footBallTournament();
    }

    private static void cricketTournament(){
        List<String> teamNames = new ArrayList<>(Arrays.asList(
                "India", "England", "Australia", "New Zealand", "Sri Lanka", "Ireland", "Zimbabwe", "Pakistan"));
        List<CricketTeam> cricketTeams = new ArrayList<>();
        for(int i = 0; i < teamNames.size(); i++){
            cricketTeams.add(new CricketTeam(teamNames.get(i), 11));
        }
        Tournament cricketTournament = new CricketTournament(cricketTeams);
        cricketTournament.startTournament();
        System.out.println("Winner of Tournament: "+cricketTournament.getWinner().getTeamName());
    }

    private static void footBallTournament(){
        List<String> teamNames = new ArrayList<>(Arrays.asList(
                "Belgium", "Brazil", "France", "England", "Uruguay", "Portugal", "Croatia", "Colombia"));
        List<FootballTeam> footballTeams = new ArrayList<>();
        for (String teamName : teamNames){
            footballTeams.add(new FootballTeam(teamName, 11));
        }

        Tournament footballTournament = new FootballTournament(footballTeams);
        footballTournament.startTournament();
        System.out.println("Winner of Tournament: "+ footballTournament.getWinner().getTeamName());
    }
}
