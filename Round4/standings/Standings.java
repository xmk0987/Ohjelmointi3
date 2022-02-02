/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.io.*;
import java.util.*;
import java.lang.String;
/**
 *
 * @author onniv
 */
public class Standings {
    private final ArrayList<Team> teams = new ArrayList<>();

    public static class Team{
        private String name = "";
        private int wins=0;
        private int ties=0;
        private int losses=0;
        private int made_goals=0;
        private int let_goals=0;
        private int points=0;



        Team(String name){

            this.name = name;

        }

        String getName(){
            return this.name;
        }

        int getWins(){
            return this.wins;
        }

        int getTies(){
            return this.ties;
        }

        int getLosses(){
            return this.losses;
        }

        int getScored(){
            return this.made_goals;
        }

        int getAllowed(){
            return this.let_goals;
        }

        int getPoints(){
            return this.points;
        }


    }


    Standings(){

    }

    public Standings(String filename)throws IOException{
        readMatchData(filename);
    }

    public void readMatchData(String filename) throws IOException {
        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        while ((strLine = br.readLine()) != null) {
            List<String> info = Arrays.asList(strLine.split("-"));

            String infoA = info.get(0);
            int goalsA = Integer.parseInt(infoA.substring(infoA.length() - 1));
            String teamNameA = infoA.substring(0, infoA.length() - 1).trim();



            String infoB = info.get(1);
            int goalsB = Integer.parseInt(infoB.substring(0,1));
            String teamNameB = infoB.substring(1).trim();

            addMatchResult(teamNameA, goalsA, goalsB, teamNameB);

        }
        fstream.close();
    }

    public void addMatchResult(String teamNameA,int goalsA, int goalsB, String teamNameB){
        var teamA = teams.stream()
                .filter(x-> x.getName().equals(teamNameA))
                .findFirst()
                .orElseGet(()->{
                    var team = new Team(teamNameA);
                    teams.add(team);
                    return team;
                });
        var teamB = teams.stream()
                .filter(x-> x.getName().equals(teamNameB))
                .findFirst()
                .orElseGet(()->{
                    var team = new Team(teamNameB);
                    teams.add(team);
                    return team;
                });


        teamA.made_goals += goalsA;
        teamB.made_goals += goalsB;

        teamA.let_goals += goalsB;
        teamB.let_goals += goalsA;

        if (goalsA> goalsB){
            teamA.wins ++;
            teamB.losses ++;
            teamA.points += 3;

        }
        else if (goalsA == goalsB){
            teamA.ties ++;
            teamB.ties ++;
            teamB.points += 1;
            teamA.points += 1;
        }
        else{
            teamA.losses ++;
            teamB.wins ++;
            teamB.points += 3;
        }



    }




    public ArrayList<Team> getTeams() {
        teams.sort((Team a, Team b)->{
            if(a.getPoints() != b.getPoints()) {
                return b.getPoints() - a.getPoints();
            }
            if((a.getScored()-a.getAllowed()) != (b.getScored()-b.getAllowed())) {
                return (b.getScored()-b.getAllowed()) - (a.getScored()-a.getAllowed());
            }
            if(a.getScored() != b.getScored()) {
                return b.getScored() - a.getScored();
            }
            return 0;}
        );
        return teams;
    }

    public void printStandings() {
        List<String> strings = new ArrayList<>();
        for(Team teamName : getTeams()) {
            strings.add(teamName.getName());
        }
        int max = strings.stream().map(String::length).max(Integer::compareTo).get();


        for(Team team : getTeams()) {
            int gamesPlayed = team.wins + team.losses + team.ties;
            String str = String.format("%d-%d",team.getScored(), team.getAllowed());
            System.out.format("%-"+max+"s %3d %3d %3d %3d %6s %3d\n", team.getName(), gamesPlayed, team.getWins(),
                    team.getTies(), team.getLosses(), str, team.getPoints());
        }
    }



}



