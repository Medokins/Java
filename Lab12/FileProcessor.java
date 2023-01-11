import java.io.*;
import java.util.*;

public class FileProcessor {
    ArrayList<String> lines;
    ArrayList<String> words;

    public FileProcessor(String filePath) {
        lines = new ArrayList<>();
        words = new ArrayList<>();

        try {
            BufferedReader fReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = fReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
            fReader.close();
        } catch(Throwable e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }

    public void getItems() {
        String[] currentLine;
        int numberOfLines = 0;
        int linesIgnored = 0;
        int numberOfPoints = 0;
        for (String line : lines) {
            numberOfLines += 1;
            int spaceCounter = 0;
            currentLine = line.split(" ");
            // ignoring comments and line that have less than 2 characters
            if(!currentLine[0].equals("#") & currentLine.length > 1) {
                // ignoring line if 2 first things in line are not digits
                char[] char1 = currentLine[0].toCharArray();
                char[] char2 = currentLine[1].toCharArray();
                if (Character.isDigit(char1[0]) & Character.isDigit(char2[0])) {
                    for (String word : currentLine) {
                        if (!word.isEmpty()) {
                            words.add(word);
                            numberOfPoints += 1;
                            spaceCounter += 1;
                            if (spaceCounter == 2) {break;}
                        }
                    }
                }
                else{
                    linesIgnored += 1;
                }
            }
            else{
                linesIgnored += 1;
            }
        }
        System.out.println("Lines in file: " + numberOfLines
                        + "\nLines ignored: " + linesIgnored
                        + "\nPoints: " + numberOfPoints/2);
    }
}