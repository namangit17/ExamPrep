package service;

import model.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class ResultManager {

    private FileManager fileManager;
    private QuestionBank questionBank;

    public ResultManager(QuestionBank questionBank) {
        this.questionBank = questionBank;
        this.fileManager = new FileManager();
    }

    public void displayResults() {

        ArrayList<String> results = fileManager.loadResults();

        System.out.println("\n========== PREVIOUS RESULTS ==========");

        if (results.isEmpty()) {
            System.out.println("No results available.");
            return;
        }

        for (int i = 0; i < results.size(); i++) {
            String[] data = results.get(i).split("\\|");

            if (data.length == 4) {
                System.out.println("\nTest " + (i + 1));
                System.out.println("Subject: " + data[0]);
                System.out.println("Questions: " + data[1]);
                System.out.println("Correct: " + data[2]);
                System.out.println("Score: " + data[3] + "%");
            }
        }
    }

    public void displayWrongQuestions() {

        ArrayList<Integer> wrongIds = fileManager.loadWrongQuestionIds();
        ArrayList<Question> questions = questionBank.getQuestions();

        System.out.println("\n========== WRONG QUESTIONS ==========");

        if (wrongIds.isEmpty()) {
            System.out.println("No incorrectly answered questions.");
            return;
        }

        boolean found = false;

        for (Integer id : wrongIds) {

            for (Question question : questions) {

                if (question.getId() == id) {

                    question.displayQuestion();

                    System.out.println(
                            "Correct Answer: " +
                            Character.toUpperCase(question.getCorrectAnswer())
                    );

                    System.out.println(
                            "Subject: " + question.getSubject()
                    );

                    System.out.println(
                            "Module: " + question.getModule()
                    );

                    System.out.println("----------------------------------");

                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No matching questions found.");
        }
    }

    public void revision(Scanner scanner) {

        ArrayList<Integer> wrongIds = fileManager.loadWrongQuestionIds();
        ArrayList<Question> questions = questionBank.getQuestions();

        if (wrongIds.isEmpty()) {
            System.out.println("\nNo questions available for revision.");
            return;
        }

        System.out.println("\n========== REVISION ==========");

        int count = 0;

        for (Integer id : wrongIds) {

            for (Question question : questions) {

                if (question.getId() == id) {

                    count++;

                    System.out.println("\nQuestion " + count);
                    question.displayQuestion();

                    System.out.println(
                            "Correct Answer: " +
                            Character.toUpperCase(question.getCorrectAnswer())
                    );

                    System.out.println(
                            "Subject: " + question.getSubject()
                    );

                    System.out.println(
                            "Module: " + question.getModule()
                    );

                    System.out.println("----------------------------------");
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("No matching questions found.");
        }

        System.out.println("\nPress Enter to return...");
        scanner.nextLine();
    }
}