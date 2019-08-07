package data;

public class GameData {
	private int score;

    public GameData(){
        score = 0;
    }
    
    public int getScore(){
        return score;
    }

    public void addAlienDestroyedScore() {
        score += 5;
    }
    public void setScore(int score){
        this.score = score;
    }
}
