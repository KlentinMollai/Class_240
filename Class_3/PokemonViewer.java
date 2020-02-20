package Class_3;

import java.io.IOException;

import javax.swing.JLabel;

public class PokemonViewer {
	static int nameIndex;
	static String rawData;
    public static void main(String[] args) throws IOException {
        String ID = "333";
        rawData = PokemonDataAPI.getData(ID);
        // Extract the name of the Pokemon
        // From the raw data.
        System.out.println(rawData);
        nameIndex = rawData.indexOf("ruby-sapphire");
        System.out.println("Index of pokemon's name is: " + nameIndex);
        int start = rawData.indexOf("ruby");
        System.out.println("Starting index: " + start);
        int end = rawData.lastIndexOf("\",\"url\"");
        System.out.println("Ending index: " + end);
        String pokemonName = rawData.substring(start, end);
        System.out.println("Pokemon's name is: " + pokemonName);
        System.out.println("Pokemon's name is: " + getName("333"));
        String URL = getPokemonImageURL("333");
        System.out.println( URL);
        
        PokemonViewerGUI p = new PokemonViewerGUI();

    }
    
    public static String getName(String ID) {
    	rawData = PokemonDataAPI.getData(ID);
    	int start = rawData.indexOf("ruby");
        System.out.println("Starting index: " + start);
        int end = rawData.lastIndexOf("\",\"url\"");
        System.out.println("Ending index: " + end);
        String pokemonName = rawData.substring(start, end);
        System.out.println("Pokemon's name is: " + pokemonName);
        return pokemonName;

    }
    
    public static String getPokemonImageURL(String ID) {
    	rawData = PokemonDataAPI.getData(ID);
    	int start = rawData.indexOf("\"front_shiny\":\"");
        int end = rawData.lastIndexOf("pokemon/shiny/333.png");
        String pokemonURL = rawData.substring(start + 15, end + 21);
        return pokemonURL;

    }
    

}

