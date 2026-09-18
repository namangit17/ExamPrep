package service;

import model.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBank {

    private ArrayList<Question> questions;
    private FileManager fileManager;

    public QuestionBank() {
        fileManager = new FileManager();
        questions = fileManager.loadQuestions();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void displayAllQuestions() {

        if (questions.isEmpty()) {
            System.out.println("\nNo questions available.");
            return;
        }

        for (Question question : questions) {
            question.displayQuestion();
            System.out.println("Subject: " + question.getSubject());
            System.out.println("Module: " + question.getModule());
            System.out.println("Difficulty: " + question.getDifficulty());
            System.out.println("----------------------------------");
        }
    }

    public void displayBySubject(Scanner scanner) {

        String subject = selectSubject(scanner);

        boolean found = false;

        for (Question question : questions) {

            if (question.getSubject().equalsIgnoreCase(subject)) {
                question.displayQuestion();
                System.out.println("Subject: " + question.getSubject());
                System.out.println("Module: " + question.getModule());
                System.out.println("Difficulty: " + question.getDifficulty());
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo questions found for this subject.");
        }
    }

    public void displayByModule(Scanner scanner) {

        String subject = selectSubject(scanner);
        String module = selectModule(scanner);

        boolean found = false;

        for (Question question : questions) {

            if (question.getSubject().equalsIgnoreCase(subject)
                    && question.getModule().equalsIgnoreCase(module)) {

                question.displayQuestion();
                System.out.println("Subject: " + question.getSubject());
                System.out.println("Module: " + question.getModule());
                System.out.println("Difficulty: " + question.getDifficulty());
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo questions found.");
        }
    }

    public void displayByDifficulty(Scanner scanner) {

        String subject = selectSubject(scanner);
        String difficulty = selectDifficulty(scanner);

        boolean found = false;

        for (Question question : questions) {

            if (question.getSubject().equalsIgnoreCase(subject)
                    && question.getDifficulty().equalsIgnoreCase(difficulty)) {

                question.displayQuestion();
                System.out.println("Subject: " + question.getSubject());
                System.out.println("Module: " + question.getModule());
                System.out.println("Difficulty: " + question.getDifficulty());
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo questions found.");
        }
    }

    public String selectSubject(Scanner scanner) {

        while (true) {

            System.out.println("\nSelect Subject:");
            System.out.println("1. Operating Systems");
            System.out.println("2. Java Programming");
            System.out.println("3. Discrete Mathematics");
            System.out.println("4. Digital Logic and Computer Architecture");

            int choice = readInteger(scanner);

            switch (choice) {
                case 1:
                    return "Operating Systems";

                case 2:
                    return "Java Programming";

                case 3:
                    return "Discrete Mathematics";

                case 4:
                    return "Digital Logic and Computer Architecture";

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public String selectModule(Scanner scanner) {

        while (true) {

            System.out.println("\nEnter Module:");
            System.out.println("Example: Module 1, Module 2, Module 3");

            String module = scanner.nextLine().trim();

            if (module.matches("(?i)module\\s+[0-9]+")) {
                String number = module.replaceAll("(?i)module\\s+", "");
                return "Module " + number;
            }

            System.out.println("Invalid module format.");
        }
    }

    public String selectDifficulty(Scanner scanner) {

        while (true) {

            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            int choice = readInteger(scanner);

            switch (choice) {
                case 1:
                    return "Easy";

                case 2:
                    return "Medium";

                case 3:
                    return "Hard";

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addQuestion(Scanner scanner) {

        int id = getNextId();

        System.out.println("\n========== ADD QUESTION ==========");

        System.out.print("Enter question: ");
        String questionText = scanner.nextLine();

        System.out.print("Enter Option A: ");
        String optionA = scanner.nextLine();

        System.out.print("Enter Option B: ");
        String optionB = scanner.nextLine();

        System.out.print("Enter Option C: ");
        String optionC = scanner.nextLine();

        System.out.print("Enter Option D: ");
        String optionD = scanner.nextLine();

        char correctAnswer;

        while (true) {
            System.out.print("Enter correct answer (A/B/C/D): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 &&
                    (input.charAt(0) == 'A' ||
                     input.charAt(0) == 'B' ||
                     input.charAt(0) == 'C' ||
                     input.charAt(0) == 'D')) {

                correctAnswer = input.charAt(0);
                break;
            }

            System.out.println("Invalid answer.");
        }

        String subject = selectSubject(scanner);
        String module = selectModule(scanner);
        String difficulty = selectDifficulty(scanner);

        Question question = new Question(
                id,
                questionText,
                optionA,
                optionB,
                optionC,
                optionD,
                correctAnswer,
                subject,
                module,
                difficulty
        );

        questions.add(question);
        fileManager.saveQuestions(questions);

        System.out.println("\nQuestion added successfully.");
        System.out.println("Question ID: " + id);
    }

    public void deleteQuestion(Scanner scanner) {

        if (questions.isEmpty()) {
            System.out.println("\nNo questions available.");
            return;
        }

        displayAllQuestions();

        System.out.print("\nEnter Question ID to delete: ");
        int id = readInteger(scanner);

        Question questionToDelete = null;

        for (Question question : questions) {
            if (question.getId() == id) {
                questionToDelete = question;
                break;
            }
        }

        if (questionToDelete == null) {
            System.out.println("Question ID not found.");
            return;
        }

        questions.remove(questionToDelete);
        fileManager.saveQuestions(questions);

        System.out.println("Question deleted successfully.");
    }

    private int getNextId() {

        int maxId = 0;

        for (Question question : questions) {
            if (question.getId() > maxId) {
                maxId = question.getId();
            }
        }

        return maxId + 1;
    }

    private int readInteger(Scanner scanner) {

        while (true) {

            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}