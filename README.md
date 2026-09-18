# ExamPrep

## ExamPrep – Multi-Subject Question Bank & Practice System

ExamPrep is a console-based Java application designed to help students practice multiple subjects through a structured question bank and MCQ practice system.

## Subjects

- Java Programming
- Operating Systems
- Discrete Mathematics
- Digital Logic and Computer Architecture

The question bank contains 800 questions, with 200 questions for each subject.

## Features

### 1. Question Bank

- View all questions
- View questions by subject
- View questions by module
- View questions by difficulty

### 2. Practice Test

- Select subject and module
- Select number of questions
- Randomize questions
- Submit answers
- Calculate score
- Save test results
- Save incorrectly answered questions

### 3. Results & Performance

- Save previous test results
- View test scores
- View correct answers
- View percentages

### 4. Revision

- Store incorrectly answered questions
- Review wrong questions
- Display correct answers

### 5. Admin / Question Management

- Add questions
- Delete questions
- View question bank

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- File Handling
- Exception Handling
- Collections.shuffle()
- Java Packages
- Text File Storage

## Project Structure

```text
JAVAPROJECTVITYARTHI/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Question.java
│   │   └── Result.java
│   │
│   └── service/
│       ├── FileManager.java
│       ├── QuestionBank.java
│       ├── Quiz.java
│       └── ResultManager.java
│
├── data/
│   ├── questions.txt
│   ├── results.txt
│   └── wrong_questions.txt
│
├── README.md
└── statement.md
## Instructions for Testing

1. Compile the project using the Java compiler:

```text
javac -d out src\model\Question.java src\model\Result.java src\service\FileManager.java src\service\QuestionBank.java src\service\Quiz.java src\service\ResultManager.java src\Main.java