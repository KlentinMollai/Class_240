package homework_2;

public abstract class Pokemon{
	
	private int HP = 1;
	private int level = 1;
	private int ID;
	
	public Pokemon(){
		
	}
	public Pokemon(int HP, int level, int ID) {
		this.HP = HP;
		this.level = level;
		this.ID = ID;
	}
	private int getHP() {
		return HP;
	}
	private void setHP(int hP) {
		HP = hP;
	}
	private int getLevel() {
		return level;
	}
	
	private int getID() {
		return ID;
	}
	protected void setID(int iD) {
		ID = iD;
	}
	private void levelUp() {
		this.level = this.getLevel() + 1;
	}
	public abstract String getName();
	
	
}