package data;

public class GameData {
	
	private int score;
	private int enemiesKilled;
	private int bulletsHit;
	private int bulletsMissed;

    public GameData(){
        score = 0;
        enemiesKilled = 0;
        bulletsHit = 0;
        bulletsMissed = 0;
    }
    
    public int getScore(){
        return score;
    }

    public void addScore(int score) {
    	this.score += score;
    }
    public void setScore(int score){
        this.score = score;
    }

	public void increaseEnemiesKilled() {
		enemiesKilled++;
		
	}
	public int getEnemiesKilled() {
		return enemiesKilled;
	}
	
	public int getBulletsHit() {
		return bulletsHit;
	}
	
	public void setBulletsHit(int bulletsHit) {
		this.bulletsHit = bulletsHit;
	}
	
	public void increaseBulletsHit() {
		bulletsHit++;
	}
	
	public int getBulletsMissed() {
		return bulletsMissed;
	}
	
	public void setBulletsMissed(int bulletsMissed) {
		this.bulletsMissed = bulletsMissed;
	}
	
	public void increaseBulletsMissed() {
		bulletsMissed++;
	}
	
	public float getAccuracy() {
		if (bulletsHit + bulletsMissed == 0) {
			return 0;
		}
		return ((float) bulletsHit / (float) (bulletsHit + bulletsMissed)) * 100.0f;
	}
}
