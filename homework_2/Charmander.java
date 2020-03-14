package homework_2;

public class Charmander extends Pokemon implements Fire {
    String name;
    
    public Charmander(int HP, int level, int ID, String name) {
  	  super (HP, level, ID);
  	  this.name = name;
    }
    @Override
	public String ember(Pokemon p) {
		String str = "\n“Pokemon "+ p.getName() +" launched Ember Attack!!”";
		return str;
	}

	@Override
	public String getName() {
		return this.name;
		
	}

}
