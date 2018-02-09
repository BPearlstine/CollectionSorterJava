// using the UniVocity csvParser to help with reading and
// searching of CSVs
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class CollectionSorterMain
{

    //initialize scanner and add paths to csv files
    public static Scanner scanner = new Scanner(System.in);
    static final String BOOKFILE = "./src/Books.csv";
    static final String COMICFILE = "./src/comics.csv";
    static final String CARDFILE = "./src/cards.csv";

    public static void main(String[] args) throws IOException
    {
        String keepRunning = "yes";
        System.out.println("Welcome to the collection sorter!");
        while (keepRunning == "yes"){

            options();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case(1):
                    addBook();
                    break;
                case(2):
                    addComic();
                    break;
                case(3):
                    addCard();
                    break;
                case(4):
                    search();
                    break;
                case(5):
                    options();
                    break;
                case(6):
                    keepRunning = "no";
                    break;
                default:
                    System.out.println("invalid input");
            }

        }
    }

    public static void options(){

        System.out.println("Enter 1 to enter a new book.");
        System.out.println("Enter 2 to enter a new comic.");
        System.out.println("Enter 3 to enter a new card.");
        System.out.println("Enter 4 to search your collection.");
        System.out.println("Enter 5 to display options.");
        System.out.println("Enter 6 to quit.");
    }

    public static void addBook()throws IOException{

        FileWriter file = new FileWriter(BOOKFILE, true);

        //get input for creating book object
        System.out.print("Enter the title of the book:");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book:");
        String author = scanner.nextLine();
        System.out.print("Enter the publication year:");
        int date = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Is the book a first edition?(y/n)");
        String editionCheck = scanner.nextLine();
        boolean edition = false;
        if (editionCheck.equalsIgnoreCase("y")){
            edition = true;
        }

        //create book object and use toString to write to csv
        Book newBook = new Book(title,author,date,edition);
        file.write(newBook.toString()+'\n');
        file.close();

    }

    public static void addComic() throws IOException{

        FileWriter file = new FileWriter(COMICFILE, true);

        //get input for creating comic object
        System.out.print("Enter the title of the comic:");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the comic:");
        String author = scanner.nextLine();
        System.out.print("Enter the publication year:");
        int date = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What issue is the comic?");
        int issue = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Is the comic a variant?(y/n)");
        String variantCheck = scanner.nextLine();
        boolean variant = false;
        if (variantCheck.equalsIgnoreCase("y")){
            variant = true;
        }

        //create comic object and use toString to write to csv
        Comic newComic = new Comic(title,author,date,issue,variant);
        file.write(newComic.toString()+'\n');
        file.close();
    }

    public static void addCard() throws IOException{
        FileWriter file = new FileWriter(CARDFILE, true);

        //get input for create magic card object
        System.out.print("Enter the name of the card:");
        String name = scanner.nextLine();
        System.out.print("Enter the Artist of the card:");
        String artist = scanner.nextLine();
        System.out.print("Enter the year it was printed:");
        int date = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the condition of the card:");
        String condition = scanner.nextLine();
        System.out.print("Is the card foil?(y/n)");
        String foilCheck = scanner.nextLine();
        boolean foil = false;
        if (foilCheck.equalsIgnoreCase("y")){
            foil = true;
        }
        System.out.print("Which set is the card from?");
        String set = scanner.nextLine();

        //create card object and use toString to write to csv
        Card newCard = new Card(name,artist,date,condition,foil,set);
        file.write(newCard.toString()+'\n');
        file.close();
    }

    public static void search() throws FileNotFoundException{
        //set csvParser settings for \n linebreaks
        //initialize csvParser object
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        CsvParser searchFile = new CsvParser(settings);

        //get input for what is being searched for
        System.out.println("Are you searching your books, comics, or cards?");
        String searchType = scanner.nextLine();
        System.out.println("What are you searching for?");
        String searchItem = scanner.nextLine();

        //begin parsing the appropriate file
        if (searchType.equalsIgnoreCase("books")){
            searchFile.beginParsing(new FileReader(BOOKFILE));
        }else if(searchType.equalsIgnoreCase("comics")){
            searchFile.beginParsing(new FileReader(COMICFILE));
        }else{
            searchFile.beginParsing(new FileReader(CARDFILE));
        }

        //turn each row into an array, search array for searchItem
        //return row if searchItem found
        String[] row;
        boolean found = false;
        while((row = searchFile.parseNext()) != null){
            if (Arrays.asList(row).contains(searchItem)){
                System.out.println(Arrays.toString(row));
                found = true;
            }
        }
        searchFile.stopParsing();
        if (found != true){
            System.out.println("Could not find.");
        }

    }
}
