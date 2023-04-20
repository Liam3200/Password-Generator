package greene.ctis310;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password = "password";
    private int wordCount;
    private int numberCount;
    private String encryptedPassword;
    private String key = "password";

    public User(String firstName, String lastName, String email, String username, int wordCount, int numberCount) throws FileNotFoundException, URISyntaxException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.wordCount = wordCount;
        this.numberCount = numberCount;
    }

    //create a method that generates a password with the given word and number count
    public String generatePassword() throws FileNotFoundException, URISyntaxException {
        //create a new string builder object
        StringBuilder password = new StringBuilder();
        //for the word count
        for (int i = 0; i < wordCount; i++) {
            //add a random word to the password
            password.append(getRandomWord());
        }
        //for the number count
        for (int i = 0; i < numberCount; i++) {
            //add a random number to the password
            password.append(getRandomNumber());
        }
        //add a random special character to the password
        password.append(getRandomSpecialCharacter());
        //encrypt the password
        key = getRandomWord();
        encryptedPassword = AES.encrypt(password.toString(), key);
        //return the password
        return password.toString();
    }

    //create a method that gets a random number from 0-9
    public int getRandomNumber() {
        //create a new random object
        Random random = new Random();
        //return a random number from 0-9
        return random.nextInt(10);
    }

    //create a method that returns a random speacial character
    public char getRandomSpecialCharacter() {
        //create a new random object
        Random random = new Random();
        //create a new array of special characters
        char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*'};
        //return a random special character
        return specialCharacters[random.nextInt(specialCharacters.length)];
    }

    //create a method that gets a random word from the 5-letter-word.txt file
    public String getRandomWord() throws FileNotFoundException, URISyntaxException {
        //create a new file object
        File file = new File(User.class.getResource("/5-letter-words.txt").toURI());
        //create a new scanner object
        Scanner scanner = new Scanner(file);
        //create a new array list
        ArrayList<String> words = new ArrayList<String>();
        //while the scanner has a next line
        while (scanner.hasNextLine()) {
            //add the next line to the array list
            words.add(scanner.nextLine());
        }
        //close the scanner
        scanner.close();
        //create a new random object
        Random random = new Random();
        //return a random word from the array list
        return words.get(random.nextInt(words.size()));
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getKey() {
        return key;
    }
}
