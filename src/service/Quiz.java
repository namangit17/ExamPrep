package service;

import model.Question;
import model.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {

    private QuestionBank questionBank;
    private FileManager fileManager;

    public Quiz(QuestionBank questionBank) {
        this.questionBank = questionBank;
        this.fileManager = new FileManager();
    }

    public void startQuiz(Scanner scanner) {

        ArrayList<Question> allQuestions = questionBank.getQuestions();

        if (allQuestions.isEmpty()) {
            System.out.println("\nNo questions available.");
            return;
        }

        String subject = questionBank.selectSubject(scanner);
        String module = questionBank.selectModule(scanner);

        ArrayList<Question> selectedQuestions = new ArrayList<>();

        for (Question question : allQuestions) {
            if (question.getSubject().equalsIgnoreCase(subject)
                    && question.getModule().equalsIgnoreCase(module)) {
                selectedQuestions.add(question);
            }
        }

        if (selectedQuestions.isEmpty()) {
            System.out.println("\nNo questions found for this subject and module.");
            return;
        }

        Collections.shuffle(selectedQuestions);

        int numberOfQuestions;

        while (true) {
            System.out.print("\nHow many questions do you want to attempt? ");
            
            try {
                numberOfQuestions = Integer.parseInt(scanner.nextLine().trim());

                if (numberOfQuestions > 0 && numberOfQuestions <= selectedQuestions.size()) {
                    break;
                }

                System.out.println(
                        "Enter a number between 1 and " + selectedQuestions.size() + "."
                );

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }

        int correctAnswers = 0;

        System.out.println("\n========== PRACTICE TEST ==========");

        for (int i = 0; i < numberOfQuestions; i++) {

            Question question = selectedQuestions.get(i);

            System.out.println("\nQuestion " + (i + 1) + " of " + numberOfQuestions);
            question.displayQuestion();

            char answer;

            while (true) {
                System.out.print("Your answer (A/B/C/D): ");
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.length() == 1 &&
                        (input.charAt(0) == 'A' ||
                         input.charAt(0) == 'B' ||
                         input.charAt(0) == 'C' ||
                         input.charAt(0) == 'D')) {

                    answer = input.charAt(0);
                    break;
                }

                System.out.println("Invalid answer. Enter A, B, C or D.");
            }

            if (answer == Character.toUpperCase(question.getCorrectAnswer())) {
                correctAnswers++;
            } else {
                fileManager.saveWrongQuestion(question.getId());
            }
        }

        Result result = new Result(
                subject,
                numberOfQuestions,
                correctAnswers
        );

        fileManager.saveResult(result.toString());

        System.out.println("\n========== TEST COMPLETED ==========");
        System.out.println("Subject: " + result.getSubject());
        System.out.println("Questions: " + result.getTotalQuestions());
        System.out.println("Correct: " + result.getCorrectAnswers());
        System.out.println("Score: " + result.getScore() + "%");
    }
}