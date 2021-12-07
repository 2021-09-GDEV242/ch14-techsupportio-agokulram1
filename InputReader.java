import java.util.HashSet;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is then chopped into words, and a set of words 
 * is provided.
 * 
 * @author Gokul Ram
 * @version 2021.12.06
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the file 
     * called "supportinput.txt".
     */
    public InputReader()
    {
        //reader = new Scanner(System.in);
        try {
        File myObj = new File("supportinput.txt");
        reader = new Scanner(myObj);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
  
    /**
     * Read a group of lines of text file until we encounter a blank line, 
     * and return it as a set of words.
     *
     * @return  A set of Strings, where each String is one of the 
     *          words typed by the user
     */
    public HashSet<String> getInput() 
    {
       
        String inputLine ="", oneLine;
        while (reader.hasNextLine()) {
            oneLine = reader.nextLine().trim().toLowerCase();
            if (oneLine.equals(""))
                break;
            inputLine = inputLine +" "+ oneLine;
        } 
        System.out.println("> "+inputLine);
        String[] wordArray = inputLine.split(" ");  // split at spaces

        // add words from array into hashset 
        HashSet<String> words = new HashSet<>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
    
    /**
     * Close the file when the application exits
     *
     */
    public void fileClose() {
      reader.close();   
    }

}
