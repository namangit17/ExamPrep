import model.Question;
import service.QuestionBank;
import service.Quiz;
import service.ResultManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        QuestionBank questionBank = new QuestionBank();
        Quiz quiz = new Quiz(questionBank);
        ResultManager resultManager = new ResultManager(questionBank);

        while (true) {

            System.out.println("\n=================================");
            System.out.println("           EXAMPREP");
            System.out.println("=================================");
            System.out.println("1. Question Bank");
            System.out.println("2. Practice Test");
            System.out.println("3. Results & Performance");
            System.out.println("4. Revision");
            System.out.println("5. Admin / Question Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    questionBankMenu(scanner, questionBank);
                    break;

                case 2:
                    quiz.startQuiz(scanner);
                    break;

                case 3:
                    resultManager.displayResults();
                    break;

                case 4:
                    resultManager.revision(scanner);
                    break;

                case 5:
                    adminMenu(scanner, questionBank);
                    break;

                case 6:
                    System.out.println("\nThank you for using ExamPrep.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void questionBankMenu(
            Scanner scanner,
            QuestionBank questionBank) {

        while (true) {

            System.out.println("\n========== QUESTION BANK ==========");
            System.out.println("1. View All Questions");
            System.out.println("2. View by Subject");
            System.out.println("3. View by Module");
            System.out.println("4. View by Difficulty");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {

                case 1:
                    questionBank.displayAllQuestions();
                    break;

                case 2:
                    questionBank.displayBySubject(scanner);
                    break;

                case 3:
                    questionBank.displayByModule(scanner);
                    break;

                case 4:
                    questionBank.displayByDifficulty(scanner);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminMenu(
            Scanner scanner,
            QuestionBank questionBank) {

        System.out.println("\n========== ADMIN ==========");

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (!password.equals("admin123")) {
            System.out.println("Incorrect password.");
            return;
        }

        while (true) {

            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. Add Question");
            System.out.println("2. Delete Question");
            System.out.println("3. View All Questions");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {

                case 1:
                    questionBank.addQuestion(scanner);
                    break;

                case 2:
                    questionBank.deleteQuestion(scanner);
                    break;

                case 3:
                    questionBank.displayAllQuestions();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}