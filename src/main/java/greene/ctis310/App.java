package greene.ctis310;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        // intialize a scanner object
        Scanner scanner = new Scanner(System.in);
        // print a welcome message
        System.out.println("Welcome to the Password Generator!");
        System.out.println("User 1 enter your information:");
        // ask user for first name
        System.out.println("Enter your first name: ");
        // get user input
        String firstName = scanner.nextLine();
        // ask user for last name
        System.out.println("Enter your last name: ");
        // get user input
        String lastName = scanner.nextLine();
        // ask user for email
        System.out.println("Enter your email: ");
        // get user input
        String email = scanner.nextLine();
        // ask user for username
        System.out.println("Enter your username: ");
        // get user input
        String username = scanner.nextLine();
        // ask user for word count
        System.out.println("How many words in your password?: ");
        // get user input
        int wordCount = scanner.nextInt();
        // ask user for number count
        System.out.println("How many numbers in your password?: ");
        // get user input
        int numberCount = scanner.nextInt();
        // clear the scanner
        scanner.nextLine();

        System.out.println("==================================");
        System.out.println("User 2 enter your information:");

        // ask user for first name
        System.out.println("Enter your first name: ");
        // get user input
        String firstName2 = scanner.nextLine();
        // ask user for last name
        System.out.println("Enter your last name: ");
        // get user input
        String lastName2 = scanner.nextLine();
        // ask user for email
        System.out.println("Enter your email: ");
        // get user input
        String email2 = scanner.nextLine();
        // ask user for username
        System.out.println("Enter your username: ");
        // get user input
        String username2 = scanner.nextLine();
        // ask user for word count
        System.out.println("How many words in your password?: ");
        // get user input
        int wordCount2 = scanner.nextInt();
        // ask user for number count
        System.out.println("How many numbers in your password?: ");
        // get user input
        int numberCount2 = scanner.nextInt();
         // close the scanner
         scanner.close();
        
        User user = new User(firstName, lastName, email, username, wordCount, numberCount);
        String userPassword = user.generatePassword();

        // create a new user object
        User user2 = new User(firstName2, lastName2, email2, username2, wordCount2, numberCount2);
        String userPassword2 = user2.generatePassword();
        
        //print out both users
        System.out.println("User 1"+user);
        System.out.println("User 2 "+user2);
        System.out.println("==================================");

        // print the user's password
        System.out.println("For user: " + user.getUsername());
        System.out.println("Your password is: " + userPassword);
        System.out.println("Your encrypted password is: " + user.getEncryptedPassword() + " and your key is: "+ user.getKey());
        System.out.println("Your decrypted password is: " + AES.decrypt(user.getEncryptedPassword(), user.getKey()));
        System.out.println("==================================");

        
        // print the user's password
        System.out.println("For user: " + user2.getUsername());
        System.out.println("Your password is: " + userPassword2);
        System.out.println("Your encrypted password is: " + user2.getEncryptedPassword() + " and your key is: "+ user2.getKey());
        System.out.println("Your decrypted password is: " + AES.decrypt(user2.getEncryptedPassword(), user2.getKey()));

           
    }
}
