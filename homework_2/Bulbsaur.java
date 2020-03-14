package homework_2;

public class Bulbsaur extends Pokemon implements Poison , Grass {
      String name;
      public Bulbsaur() {
    	  
      }
      public Bulbsaur(int HP, int level, int ID, String name) {
    	  super (HP, level, ID);
    	  this.name = name;
      }

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public String wineWhip(Pokemon p) {
		String str = "\n“Pokemon "+ p.getName()+"  launched Wine Whip Attack!!” ";
		return str;
	}

	@Override
	public String poisonPower(Pokemon p) {
		String str = "\n“Pokemon "+ p.getName() + " launched Poison Power Attack!!”";
		return str;
	}
	
}
