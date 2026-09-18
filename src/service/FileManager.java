package service;

import model.Question;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String QUESTION_FILE = "data/questions.txt";
    private static final String RESULT_FILE = "data/results.txt";
    private static final String WRONG_FILE = "data/wrong_questions.txt";

    public ArrayList<Question> loadQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        File file = new File(QUESTION_FILE);

        System.out.println("Loading questions from: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("questions.txt not found.");
            return questions;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("~", -1);

                if (data.length != 10) {
                    System.out.println("Invalid question format: " + line);
                    continue;
                }

                Question question = new Question(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6].charAt(0),
                        data[7],
                        data[8],
                        data[9]
                );

                questions.add(question);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }

        System.out.println("Questions loaded: " + questions.size());

        return questions;
    }

    public void saveQuestions(ArrayList<Question> questions) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(QUESTION_FILE))) {

            for (Question question : questions) {
                writer.write(question.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving questions: " + e.getMessage());
        }
    }

    public void saveResult(String result) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(RESULT_FILE, true))) {

            writer.write(result);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }

    public ArrayList<String> loadResults() {

        ArrayList<String> results = new ArrayList<>();

        File file = new File(RESULT_FILE);

        if (!file.exists()) {
            return results;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    results.add(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading results: " + e.getMessage());
        }

        return results;
    }

    public void saveWrongQuestion(int questionId) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(WRONG_FILE, true))) {

            writer.write(String.valueOf(questionId));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving wrong question: " + e.getMessage());
        }
    }

    public ArrayList<Integer> loadWrongQuestionIds() {

        ArrayList<Integer> ids = new ArrayList<>();

        File file = new File(WRONG_FILE);

        if (!file.exists()) {
            return ids;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    ids.add(Integer.parseInt(line.trim()));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading wrong questions: " + e.getMessage());
        }

        return ids;
    }
}