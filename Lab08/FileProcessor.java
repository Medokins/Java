import java.io.*;
import java.util.*;

public class FileProcessor {
    ArrayList<String> lines;
    ArrayList<String> words;

    public FileProcessor(String filePath) {
        lines = new ArrayList<String>();
        words = new ArrayList<String>();

        try {
            BufferedReader fReader = new BufferedReader(new FileReader(filePath));
            String line;
            int i = 1;
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

    public void ex1() {
        System.out.println("Printing first three lines of a file:");
        for (int i = 0; i < 3; i++) {
            System.out.println(lines.get(i));
        }
        System.out.println("Printing last three lines of a file:");
        for (int i = 3; i > 0; i--) {
            System.out.println(lines.get(lines.size() - i));
        }
    }

    public void ex2() {
        String[] currentLine;
        for (String line : lines) {
            currentLine = line.split("\\s");
            for (String word : currentLine) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        System.out.println("Tab Size: " + words.size());
    }
    public void ex3() {
        String[] copy = new String[words.size()];
        for(int i = 0; i < words.size(); i++){
            copy[i] = words.get(i);
        }
        

        long start = System.currentTimeMillis();
        Arrays.parallelSort(copy);
        long finish = System.currentTimeMillis();
        System.out.println("Time elapsed copy: " + (finish - start));

        start = System.currentTimeMillis();
        Collections.sort(words);
        finish = System.currentTimeMillis();
        System.out.println("Time elapsed original: " + (finish - start));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        System.out.println("Word at index: " + index + " is '" + words.get(index) + "'");
    }

    public void ex4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        for (String word : words) {
            if (keys.contains(word)) {
                int index = keys.indexOf(word);
                values.set(index, values.get(index) + 1);
            } else {
                keys.add(word);
                values.add(1);
            }
        }

        for (int j = 0; j < N; j++) {
            int max = values.get(0);
            int index = 0;
            for (int i = 1; i < values.size(); i++) {
                if (values.get(i) > max) {
                    max = values.get(i);
                    index = i;
                }
            }
            System.out.println("Word: '" + keys.get(index) + "' occurences: " + max);
            keys.remove(index);
            values.remove(index);
        }
    }
}