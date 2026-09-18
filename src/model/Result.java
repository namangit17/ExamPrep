package model;

public class Result {

    private String subject;
    private int totalQuestions;
    private int correctAnswers;
    private int score;

    public Result(String subject, int totalQuestions, int correctAnswers) {
        this.subject = subject;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = (correctAnswers * 100) / totalQuestions;
    }

    public String getSubject() {
        return subject;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return subject + "|" +
               totalQuestions + "|" +
               correctAnswers + "|" +
               score;
    }
}