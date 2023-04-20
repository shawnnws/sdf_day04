package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * IMPORTANT: How to create new directory and file, read info from txt file, and manipulate the info.
 */

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //Read directory and file info from main method argument
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        //Create new directory
        File newDir = new File(dirPath);
        if (newDir.exists()) {
            System.out.println("Directory already exists");
        }
        else {
            newDir.mkdir();
        }

        //Create new file in directory
        File newFile = new File(dirPathFileName);
        if (newFile.exists()) {
            System.out.println("File already exists");
        }
        else {
            newFile.createNewFile();
        }

        //Use FileReader and BufferedReader to read file
        FileReader fr = new FileReader(dirPathFileName);
        BufferedReader br = new BufferedReader(fr);

        //Variable to store whole file content
        StringBuilder sbFileContent = new StringBuilder();
        //Variable to read each line of content
        String lineInput = "";

        //while loop to read file into string variable
        while ((lineInput = br.readLine()) != null) {
            sbFileContent.append(lineInput);
        }

        //Close readers.
        br.close();
        fr.close();

        System.out.println(sbFileContent.toString().toUpperCase());

        //Convert StringBuilder to String in order to utilize String methods
        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replaceAll("[^a-zA-Z0-9]", " ");


        //Create an ArrayList to store all unique words from file.
        String[] fileContentArray = fileContent.split(" ");

        //Create a Hashmap to store all unique words.
        Map<String, Integer> words = new HashMap<String, Integer>();

        for (String word : fileContentArray) {
            if (!(words.containsKey(word))) {
                words.put(word, 1);
            }
            else if (word != " ") {
                words.put(word, words.get(word) + 1);
            }
        }
        System.out.println(words);
    }
   }

