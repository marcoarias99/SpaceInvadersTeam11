package internal;

import levels.Level;
import levels.Level1;
import levels.Level10;
import levels.Level11;
import levels.Level12;
import levels.Level13;
import levels.Level14;
import levels.Level15;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.Level5;
import levels.Level6;
import levels.Level7;
import levels.Level8;
import levels.Level9;

public class LevelRect extends Rectangle {
	
	private int level;

	public LevelRect(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Level getLevel() {
		switch(level) {
		case 1: return new Level1();
		case 2: return new Level2();
		case 3: return new Level3();
		case 4: return new Level4();
		case 5: return new Level5();
		case 6: return new Level6();
		case 7: return new Level7();
		case 8: return new Level8();
		case 9: return new Level9();
		case 10: return new Level10();
		case 11: return new Level11();
		case 12: return new Level12();
		case 13: return new Level13();
		case 14: return new Level14();
		case 15: return new Level15();
		}
		
		throw new RuntimeException("Unknown level: " + level + ". This should never happen!");
	}
	
}
