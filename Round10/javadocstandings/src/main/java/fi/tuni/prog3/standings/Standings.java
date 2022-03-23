package fi.tuni.prog3.standings;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;

/**
 * A class for maintaining team statistics and standings. Team standings are determined by the following rules:
 * <ul>
 *     <li>Primary rule: points total. Higher points come first.</li>
 *     <li>Secondary rule: goal difference (scored minus allowed). Higher difference comes first.</li>
 *     <li>Tertiary rule: number of goals scored. Higher number comes first.</li>
 *     <li>Last rule: natural String order of team names.</li>
 * </ul>
 */
public class Standings {
    private ArrayList<Team> teamlist;

    /**
     *   A class for storing statistics of a single team. The class offers only public getter functions. The enclosing class Standings is responsible for setting and updating team statistics.
     */
    public static class Team {
        private String name;
        private int wins;
        private int ties;
        private int losses;
        private int scored;
        private int allowed;
        private int points;

        /**
         * Constructs a Team object for storing statistics of the named team.
         * @param name the name of the team whose statistics the new team object stores.
         */
        public Team(String name) {
            this.name = name;
            this.wins = 0;
            this.ties = 0;
            this.losses = 0;
            this.scored = 0;
            this.allowed = 0;
            this.points = 0;
        }

        /**
         * Returns the name of the team.
         * @return the name of the team.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Returns the number of wins of the team.
         * @return the number of wins of the team.
         */
        public int getWins() {
            return this.wins;
        }

        /**
         * Returns the number of ties of the team.
         * @return the number of ties of the team.
         */
        public int getTies() {
            return this.ties;
        }

        /**
         * Returns the number of losses of the team.
         * @return the number of losses of the team.
         */
        public int getLosses() {
            return this.losses;
        }

        /**
         * Returns the number of goals scored by the team.
         * @return the number of goals scored by the team.
         */
        public int getScored() {
            return this.scored;
        }

        /**
         * Returns the number of goals allowed (conceded) by the team.
         * @return the number of goals allowed (conceded) by the team.
         */
        public int getAllowed() {
            return this.allowed;
        }

        /**
         * Returns the overall number of points of the team.
         * @return the overall number of points of the team.
         */
        public int getPoints() {
            return this.points;
        }
    }

    /**
     * Constructs an empty Standings object.
     */
    public Standings() {
        this.teamlist = new ArrayList<Team>();
    }

    /**
     * Constructs a Standings object that is initialized with the game data read from the specified file. The result is identical to first constructing an empty Standing object and then calling {@link #readMatchData(filename)}.
     * @param filename the name of the game data file to read.
     * @throws IOException if there is some kind of an IO error (e.g. if the specified file does not exist).
     */
    public Standings(String filename)throws IOException {
        try(var file = new BufferedReader(new FileReader(filename))) {

            String standingStr;
            String[] split;
            String[] teamScores;
            this.teamlist = new ArrayList<Team>();

            while((standingStr = file.readLine()) != null) {
                split = standingStr.split("\\t",3);
                teamScores = split[1].split("-",2);

                int score1 = Integer.valueOf(teamScores[0]);
                int score2 = Integer.valueOf(teamScores[1]);

                addMatchResult(split[0], score1, score2, split[2]);
            }
        }
    }

    /**
     * <p> Reads game data from the specified file and updates the team statistics and standings accordingly.</p>
     * <p> The match data file is expected to contain lines of form "teamNameA\tgoalsA-goalsB\tteamNameB". Note that the '\t' are tabulator characters.</p>
     * <p> E.g. the line "Iceland\t3-2\tFinland" would describe a match between Iceland and Finland where Iceland scored 3 and Finland 2 goals.</p>
     * @param filename the name of the game data file to read.
     * @throws IOException if there is some kind of an IO error (e.g. if the specified file does not exist).
     */
    public final void readMatchData(String filename)throws IOException {
        try(var file = new BufferedReader(new FileReader(filename))) {

            String standingStr;
            String[] split;
            String[] teamScores;

            while((standingStr = file.readLine()) != null) {
                split = standingStr.split("\\t",3);
                teamScores = split[1].split("-",2);

                int score1 = Integer.valueOf(teamScores[0]);
                int score2 = Integer.valueOf(teamScores[1]);

                addMatchResult(split[0], score1, score2, split[2]);
            }
        }
    }

    /**
     * Updates the team statistics and standings according to the match result described by the parameters.
     * @param teamNameA the name of the first ("home") team.
     * @param goalsA the number of goals scored by the first team.
     * @param goalsB the number of goals scored by the second team.
     * @param teamNameB  the name of the second ("away") team.
     */
    public void addMatchResult(String teamNameA, int goalsA, int goalsB, String teamNameB) {
        var team1 = teamlist.stream().filter(x -> x.getName().equals(teamNameA)).findFirst().orElseGet(()->{
            var team = new Team(teamNameA);
            teamlist.add(team);
            return team;
        });

        var team2 = teamlist.stream().filter(x -> x.getName().equals(teamNameB)).findFirst().orElseGet(()->{
            var team = new Team(teamNameB);
            teamlist.add(team);
            return team;
        });

        team1.scored += goalsA;
        team1.allowed += goalsB;

        team2.scored += goalsB;
        team2.allowed += goalsA;

        if (goalsA > goalsB) {
            team1.wins += 1;
            team2.losses += 1;
            team1.points += 3;
        }
        else if (goalsA < goalsB) {
            team2.wins += 1;
            team1.losses += 1;
            team2.points += 3;
        }
        else {
            team1.ties += 1;
            team2.ties += 1;
            team1.points += 1;
            team2.points += 1;
        }
    }

    /**
     * Returns a list of the teams in the same order as they would appear in a standings table.
     * @return a list of the teams in the same order as they would appear in a standings table.
     */
    public List<Team> getTeams() {
        for (int i = 0; i<teamlist.size(); i++){
            for (Team a: this.teamlist){
                if (this.teamlist.get(i).points > a.points)
                {
                    int index = this.teamlist.indexOf(a);
                    Collections.swap(teamlist, i, index);

                }

            }
        }
        for (int i = 0; i<teamlist.size(); i++){
            for (Team a: this.teamlist){
                if (this.teamlist.get(i).points == a.points && this.teamlist.get(i).scored-this.teamlist.get(i).allowed > a.scored-a.allowed)
                {
                    int index = this.teamlist.indexOf(a);
                    Collections.swap(teamlist, i, index);

                }

            }
        }
        for (int i = 0; i<teamlist.size(); i++){
            for (Team a: this.teamlist){
                if (this.teamlist.get(i).points == a.points && this.teamlist.get(i).scored-this.teamlist.get(i).allowed == a.scored-a.allowed && this.teamlist.get(i).scored > a.scored)
                {
                    int index = this.teamlist.indexOf(a);
                    Collections.swap(teamlist, i, index);

                }

            }
        }
        for (int i = 0; i<teamlist.size(); i++){
            for (Team a: this.teamlist){
                if (this.teamlist.get(i).points == a.points && this.teamlist.get(i).scored-this.teamlist.get(i).allowed == a.scored-a.allowed && this.teamlist.get(i).scored == a.scored)
                {
                    if ((this.teamlist.get(i).name.compareTo(a.name))>1){
                        int index = this.teamlist.indexOf(a);
                        Collections.swap(teamlist, i, index);
                    }
                }

            }
        }
        return this.teamlist;
    }

    /**
     * Prints a formatted standings table to the provided output stream.
     * @param out the output stream to use when printing the standings table.
     */
    public void printStandings(PrintStream out) {
        System.out.println(out);
    }
}