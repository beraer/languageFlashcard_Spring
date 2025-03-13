package tpo02.s29315tpo02.controller;

import org.springframework.stereotype.Component;
import tpo02.s29315tpo02.model.Entry;
import tpo02.s29315tpo02.repository.EntryRepository;
import tpo02.s29315tpo02.service.display.DisplayService;

import java.util.List;
import java.util.Scanner;

@Component
public class FlashcardsController {
    private DisplayService displayService;
    private EntryRepository entryRepository;
    private Scanner scanner;

    public FlashcardsController(DisplayService displayService, EntryRepository entryRepository) {
        this.displayService = displayService;
        this.entryRepository = entryRepository;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        String choice = scanner.nextLine();
        printOptions();
        while(true){
            switch(choice){
                case "1":
                    addNewWord();
                    break;
                case "2":
                    displayWords();
                    break;
                case "3":
                    runTest();
                    break;
                case "4":
                    System.exit(0);
            }
        }
    }

    private void addNewWord() {
        System.out.println("enter a polish word: ");
        String polishWord = scanner.nextLine();
        System.out.println("enter a german word: ");
        String germanWord = scanner.nextLine();
        System.out.println("enter a english word: ");
        String englishWord = scanner.nextLine();

        Entry entry = new Entry(polishWord, germanWord, englishWord);
        entryRepository.addEntry(entry);
    }

    private void displayWords() {
        List<Entry> entries = entryRepository.getEntries();
        System.out.println("\n---dictionary content---");
        entries.forEach(entry -> {displayService.display(entries);});
    }

    private void runTest() {
        System.out.println("\n---Welcome to Test---");
        Entry randomEntry = entryRepository.getRandomEntry();
        String randomWord = randomEntry.getRandomWord();

        String returnedRandomLang = "";
        String correctAnswer1 = "";
        String correctAnswer2 = "";
        String targetLan1 = "";
        String targetLan2 = "";

        if (randomWord.equals(randomEntry.getPolish())) {
            returnedRandomLang = "Polish";
            correctAnswer1 = randomEntry.getEnglish();
            correctAnswer2 = randomEntry.getGerman();
            targetLan1 = "English";
            targetLan2 = "German";
        } else if (randomWord.equals(randomEntry.getEnglish())) {
            returnedRandomLang = "English";
            correctAnswer1 = randomEntry.getPolish();
            correctAnswer2 = randomEntry.getGerman();
            targetLan1 = "Polish";
            targetLan2 = "German";
        } else if (randomWord.equals(randomEntry.getGerman())) {
            returnedRandomLang = "German";
            correctAnswer1 = randomEntry.getEnglish();
            correctAnswer2 = randomEntry.getPolish();
            targetLan1 = "English";
            targetLan2 = "Polish";
        }

        System.out.println("\nTranslate this " + returnedRandomLang + " word " + "'" + randomWord + "'" );
        System.out.println("\nWrite your answer for " + targetLan1 + ":");
        String firstAnswer = scanner.nextLine();
        System.out.println("\nWrite your answer for " + targetLan2 + ":");
        String secondAnswer = scanner.nextLine();

        if (firstAnswer.equalsIgnoreCase(correctAnswer1) && secondAnswer.equalsIgnoreCase(correctAnswer2)) {
            System.out.println("bravo");
        }else {
            System.out.println("you need to work hard :(");
        }

    }

    private void printOptions() {
        System.out.println("===OPTIONS===");
        System.out.println("1. Add word");
        System.out.println("2. Display words");
        System.out.println("3. Run test");
        System.out.println("4. Exit");
    }
}
