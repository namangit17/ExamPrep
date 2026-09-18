package model;

public class Question {

    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctAnswer;
    private String subject;
    private String module;
    private String difficulty;

    public Question(int id, String questionText,
                    String optionA, String optionB,
                    String optionC, String optionD,
                    char correctAnswer,
                    String subject, String module,
                    String difficulty) {

        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.subject = subject;
        this.module = module;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public String getSubject() {
        return subject;
    }

    public String getModule() {
        return module;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void displayQuestion() {
        System.out.println("\nQuestion " + id);
        System.out.println(questionText);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
    }

    @Override
    public String toString() {
        return id + "~" +
               questionText + "~" +
               optionA + "~" +
               optionB + "~" +
               optionC + "~" +
               optionD + "~" +
               correctAnswer + "~" +
               subject + "~" +
               module + "~" +
               difficulty;
    }
}