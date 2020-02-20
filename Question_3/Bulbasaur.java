package Question_3;

public class Bulbasaur {
	
	int bulbasaurID = 1;
	int ivysaurID = 2;
	int venusaurID = 3;
	private int level;
	private int id;
	
	public Bulbasaur() {
		id = 1;
		level = 1;
	}
	public Bulbasaur(int level, String name, int id) {
		this.level = level;
		this.id = id;
	}
	
	public void setLevel(int lv) {
		level = lv;
		if(level < 16) {
			id = 1;
		}
		else if (level <= 16 && level <= 31) {
			id = 2;
		}
		else if(level >= 32) {
			id = 3;
		}
	}
	public int getLevel() {
		return 0;
	}
	public String getName() {
		if(id == 1) {
			return "Bulbasaur";
					}
		else if(id == 2) {
			return "Ivysaur"; 
		}
		else if (id == 3) {
			return "Venusaur";
			
		}
		return "";
				
	}
	public int getId() {
		return id;
	}
	@Override	 
	public String toString() {
		return String.format("ID %d: \nLevel %d: ",id,level);
	}
	
	
	 
	    public boolean equals(Bulbasaur o) {    
	        if (this.id == o.id && this.level == o.level) {
	        	return true;
	        }
	        return false;
	    } 
	 
	 public Bulbasaur copy(Bulbasaur c)
	 {
	     c.id = this.id;
	     c.level = this.level;
	     
	     return c;
	 }
	public static void main(String[] args) {
		
		Bulbasaur b = new Bulbasaur();
		System.out.println(b.toString());

	}

}
