import java.util.*;

public class FootballTournament extends Tournament{
    private List<FootballTeam>  groupA;
    private List<FootballTeam>  groupB;
    private List<FootballTeam>  groupC;
    private List<FootballTeam>  groupD;
    private List<FootballTeam>  semiFinalists;

    public FootballTournament(List<FootballTeam> teamList) {
        super(teamList);
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();
        groupC = new ArrayList<>();
        groupD = new ArrayList<>();
        semiFinalists = new ArrayList<>();
    }

    @Override
    void fixtures() {
        for(int i = 0; i < teamList.size(); i+=4){
            groupA.add((FootballTeam)teamList.get(i));
            groupB.add((FootballTeam)teamList.get(i+1));
            groupC.add((FootballTeam)teamList.get(i+2));
            groupD.add((FootballTeam)teamList.get(i+3));
        }
    }

    @Override
    Team playTournament() {
        System.out.printf("\tGroup: %c\n\n", 'A');
        groupMatch(groupA);

        System.out.printf("\tGroup: %c\n\n", 'B');
        groupMatch(groupB);

        System.out.printf("\tGroup: %c\n\n", 'C');
        groupMatch(groupC);

        System.out.printf("\tGroup: %c\n\n", 'D');
        groupMatch(groupD);

        System.out.printf("\tSemi-Final: %s V/S %s\n\n", semiFinalists.get(0).getTeamName(), semiFinalists.get(3).getTeamName());
        FootballTeam winner1 = knockoutMatch(semiFinalists.get(0), semiFinalists.get(3));
        System.out.printf("\tSemi-Final: %s V/S %s\n\n", semiFinalists.get(1).getTeamName(), semiFinalists.get(2).getTeamName());
        FootballTeam winner2 = knockoutMatch(semiFinalists.get(1), semiFinalists.get(2));

        return  knockoutMatch(winner1, winner2);
    }

    private void groupMatch(List<FootballTeam> groupTeams){
        int matchNum = 1;
        for(int i = 0; i < groupTeams.size()-1; i++){
            for(int j = i+1; j < groupTeams.size(); j++){
                FootballTeam team1 = groupTeams.get(i);
                FootballTeam team2 = groupTeams.get(j);
                System.out.printf("\tMatch %d between: %s V/S %s \n", matchNum++, team1.getTeamName(), team2.getTeamName());
                leagueMatch(team1, team2);
            }
        }
        Collections.sort(groupTeams, new Comparator<FootballTeam>() {
            @Override
            public int compare(FootballTeam ft1, FootballTeam ft2) {
                return ft2.getTeamScore()-ft2.getTeamScore();
            }
        });

        System.out.printf("Group Stage Winner: \t %s \n\n", groupTeams.get(0).getTeamName());
        semiFinalists.add(groupTeams.get(0));
    }

    private void leagueMatch(FootballTeam team1, FootballTeam team2){
        Random random = new Random();
        int goalsFor = random.nextInt(2)+3;
        int goalsAgainst = random.nextInt(2);
        if(random.nextInt(1) == 0){
            team1.setGoalsFor(goalsFor);
            team1.setGoalsAgainst(goalsAgainst);
            System.out.printf("\t Scoreboard: %d : %d\n\n", goalsFor, goalsAgainst);
            System.out.printf("\tWinner: %s\n\n", team1.getTeamName());
        }else{
            team2.setGoalsFor(goalsFor);
            team2.setGoalsAgainst(goalsAgainst);
            System.out.printf("\t Scoreboard: %d : %d\n\n", goalsAgainst, goalsFor);
            System.out.printf("\tWinner: %s\n\n", team2.getTeamName());
        }
    }

    private FootballTeam knockoutMatch(FootballTeam team1, FootballTeam team2){
        Random random = new Random();
        if(random.nextInt(1)==0){
            return  team1;
        }else{
            return team2;
        }
    }
}
