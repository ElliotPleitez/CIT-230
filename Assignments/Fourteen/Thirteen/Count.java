package Fourteen.Thirteen;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Count {
    String fileName;
    File file;
    int lineCount, wordCount, characterCount = 0;
    
    public static void main(String[] args) {
        Count count = new Count();
        count.Run(args[0]);
    }
    
    public void Run(String input){
        this.fileName = input;
        
        try{
            file = new File(fileName);
            if(file.canRead()){
                Scanner readFile = new Scanner(file);
                while(readFile.hasNextLine()){
                    Scanner readLine = new Scanner(readFile.nextLine());
                    while(readLine.hasNext()){
                        Scanner readWord = new Scanner(readLine.next());
                        while(readWord.hasNext()){
                            String word = readWord.next();
                            characterCount++; //+1 for the space character
                            characterCount += word.length();
                        }
                        wordCount++;
                    }
                    lineCount++;
                }
                
                System.out.println("File " + file.getName() + " has");
                System.out.println(lineCount + " characters");
                System.out.println(wordCount + " words");
                System.out.println(characterCount + " lines");
            }
            else{
                throw new IOException("Cannot read file.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally{
            
        }
    }

}
