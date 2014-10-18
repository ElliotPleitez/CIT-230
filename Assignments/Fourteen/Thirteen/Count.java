package Fourteen.Thirteen;

//Author: Elliot J Pleitez
//Date: 2014-10-16
//Description: This application takes an argument, the full path of a file. It then reads the content of that file and reports the character, word and line count

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Count {
    //Fields
    String fileName;
    File file;
    int lineCount, wordCount, characterCount = 0;
    
    //Main stub (entry)
    public static void main(String[] args) {
        //create an instance of self and check input arguments, if they exist then move forward. otherwise notify user
        Count count = new Count();
        if(args.length == 0){
            System.out.println("Try again, file path not provided. Press enter to exit...");
            new java.util.Scanner(System.in).nextLine();
        }
        else{
            count.runMyself(args[0]);
        }
    }
    
    public void runMyself(String input){
        this.fileName = input;
        //encapsulate within try while operating within File class.
        try{
            file = new File(fileName);
            //Before beginning, make sure file exists and can be read
            if(file.exists() && file.canRead()){
                //open file and begin reading...
                Scanner readFile = new Scanner(file);
                //while there is a line to read...
                while(readFile.hasNextLine()){
                    Scanner readLine = new Scanner(readFile.nextLine());
                    //while there is a word to read...
                    while(readLine.hasNext()){
                        Scanner readWord = new Scanner(readLine.next());
                        //while there are characters to read...
                        while(readWord.hasNext()){
                            String word = readWord.next();
                            this.characterCount++; //+1 for the space character and return
                            //append to character count
                            this.characterCount += word.length();
                        }
                        //append to word count
                        this.wordCount++;
                    }
                    //append to line count
                    this.lineCount++;
                }
                
                //echo results to console
                System.out.println("File " + file.getName() + " has:");
                System.out.println("\t" + this.characterCount + " characters (including space and return)");
                System.out.println("\t" + this.wordCount + " words");
                System.out.println("\t" + this.lineCount + " lines");
            }
            else{
                //if file cannot be read
                throw new IOException("Cannot read file.");
            }
        } catch (IOException e) {
            //return type of error thrown during File class
            System.out.println(e.getMessage());
        }
    }
}
