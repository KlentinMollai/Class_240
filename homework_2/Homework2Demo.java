package homework_2;

public class Homework2Demo {
    public static void main(String[] args) {
    	Pokemon p1 = new Charizard();
        Pokemon p2 = new Charmeleon();
        Pokemon p3 = new Ivysaur();
        Bulbsaur p4 = new Bulbsaur(1,1,1, "Bulbsaur");
        Charmander p5 = new Charmander(2,2,2, "Charmander");
        Homework2Demo d = new Homework2Demo();
        System.out.println("I am "+ d.speak(p1));
        System.out.println("\n“Pokemon Bulbsaur is of type” "+p4.type+p4.poisonPower(p4));
        System.out.println("\n“Pokemon Bulbsaur is of type” "+p4.type1+p4.wineWhip(p4));
        System.out.println(p5.ember(p5));
       
    }
    
    public String speak(Pokemon p) {
    	return p.getName();
    }
}
