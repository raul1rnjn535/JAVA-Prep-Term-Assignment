import java.util.ArrayList;
import java.util.List;

public abstract class Tournament {
    protected List<? extends Team> teamList;
    private Team winner;

    public Tournament(List<? extends Team> teamList) {
        this.teamList = teamList;
    }


    final void startTournament(){
        fixtures();
        winner = playTournament();
        getWinner();
    }

    abstract void fixtures();

    abstract Team playTournament();

    Team getWinner(){
        return winner;
    }
}
