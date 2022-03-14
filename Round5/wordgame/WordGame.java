import java.io.*;
import java.util.*;
import java.lang.String;


import static java.lang.Character.toUpperCase;

public class WordGame {
    private final ArrayList<String> words = new ArrayList<>();
    private WordGameState state;


    public static class WordGameState{
        private String word = "";
        private String secret_word = "";
        private int mistakes = 0;
        private int mistake_limit = 0;
        private int missing_chars = 0;
        private final ArrayList<Character> guessed_chars = new ArrayList<>();

        private WordGameState(String gameWord){
            this.secret_word = gameWord;
            this.word = "_".repeat(gameWord.length());
            this.missing_chars = gameWord.length();
        }

        String getWord(){
            return this.word;
        }

        private String getSecret_word(){return this.secret_word;}

        int getMistakes(){
            return this.mistakes;
        }

        int getMistakeLimit(){
            return this.mistake_limit;
        }

        int getMissingChars(){
            return this.missing_chars;
        }

    }

    public WordGame(String wordFilename)throws IOException{
        FileInputStream fstream = new FileInputStream(wordFilename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        while ((strLine = br.readLine()) != null) {
            words.add(strLine);

        }
        fstream.close();
    }

    public void initGame(int wordIndex, int mistakeLimit){
        String game_word = words.get(wordIndex % words.size());
        var game = new WordGameState(game_word);
        game.mistake_limit = mistakeLimit;
        this.state = game;

    }

    public boolean isGameActive(){
        if (state == null){
            return false;
        }
        else if(state.missing_chars == 0){
            return false;

        }
        else if(state.mistakes > state.mistake_limit){
            return false;
        }
        return true;
    }

    public WordGameState getGameState() throws GameStateException{
        if (!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        else{
            return state;
        }
    }

    public WordGameState guess(char c) throws GameStateException{
        if (!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        else{
            if(state.getSecret_word().indexOf(Character.toUpperCase(c)) == -1
                    && state.getSecret_word().indexOf(Character.toLowerCase(c)) == -1){
                state.mistakes ++;
                if(state.mistakes > state.mistake_limit){
                    state.word = state.secret_word;
                }
                return state;
            }
            else{
                if(state.guessed_chars.contains(Character.toUpperCase(c)) ||
                        state.guessed_chars.contains(Character.toLowerCase(c))){
                    state.mistakes ++;
                    if(state.mistakes > state.mistake_limit){
                        state.word = state.secret_word;
                    }
                    return state;
                }
                else{
                    int count = 0;
                    for (int i = 0; i < state.getSecret_word().length(); i++){
                        if(state.getSecret_word().charAt(i) == Character.toUpperCase(c) ||state.getSecret_word().charAt(i) == Character.toLowerCase(c)){
                            count ++;

                            char[] strChars = state.word.toCharArray();
                            strChars[i] = Character.toLowerCase(c);
                            String newstring = String.valueOf(strChars);

                            state.word = newstring;


                        }
                    }
                    state.missing_chars -= count;
                    state.guessed_chars.add(c);

                    return state;
                }

            }
        }

    }

    public WordGameState guess(String word) throws GameStateException{
        if (!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        else{
            if (state.getSecret_word().equals(word)){
                state.missing_chars = 0;
                state.word = word;
                return state;
            }
            else{
                state.mistakes ++;
                if(state.mistakes > state.mistake_limit){
                    state.word = state.secret_word;
                }
                return state;
            }

        }

    }



}
