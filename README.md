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
## Main Classes

### Main.java

The entry point of the application. It provides the main menu and connects the different modules.

### Question.java

Represents an individual question and stores its question text, options, correct answer, subject, module, and difficulty.

### Result.java

Represents a completed test result and stores the subject, total questions, correct answers, and score.

### QuestionBank.java

Handles loading, displaying, filtering, adding, and deleting questions.

### Quiz.java

Handles practice tests, question selection, answer checking, score calculation, and recording incorrect answers.

### FileManager.java

Handles file operations for `questions.txt`, `results.txt`, and `wrong_questions.txt`.

### ResultManager.java

Handles saving and displaying previous results and managing incorrectly answered questions for revision.

## How to Compile

Open a terminal in the project root directory and run:

```bash
javac -d out src\model\Question.java src\model\Result.java src\service\FileManager.java src\service\QuestionBank.java src\service\Quiz.java src\service\ResultManager.java src\Main.java
## How to Run

After compilation, run:

java -cp out Main

## Admin Access

The admin module is password protected.

**Default password:** `admin123`

## Data Storage

The application uses text files for data storage:

- `questions.txt` – stores the question bank
- `results.txt` – stores completed test results
- `wrong_questions.txt` – stores incorrectly answered questions for revision

## Question Format

Questions are stored using the following format:

ID|Question|OptionA|OptionB|OptionC|OptionD|CorrectAnswer|Subject|Module|Difficulty

## Functional Modules

### 1. Question Bank

Allows users to browse and filter questions. Admin users can add and delete questions.

### 2. Practice Test

Allows users to select a subject and attempt randomized MCQ tests with automatic answer checking and score calculation.

### 3. Results

Displays previous test results.

### 4. Revision

Displays questions answered incorrectly in previous tests.

### 5. Admin

Provides password-protected question management.

## Instructions for Testing

1. Compile the project using the compilation command.
2. Run the application.
3. Verify that the question bank loads successfully.
4. Test the Question Bank module.
5. Start and complete a Practice Test.
6. Verify the calculated score.
7. Open Results and verify that the result is saved.
8. Open Revision and verify incorrectly answered questions.
9. Open Admin and test adding and deleting questions.

## Error Handling

The application handles invalid user input, invalid menu selections, and file-reading/writing errors.

## Future Enhancements

- Graphical user interface
- Database integration
- User accounts
- Timed examinations
- Performance analytics
- Difficulty-based adaptive tests
- Larger question bank
- Online question synchronization

## Documentation

The `docs` folder contains:

- System architecture diagram
- Workflow diagram
- Use case diagram
- Class diagram
- Sequence diagram
- Storage design
- Final project report

## Project Objective

The objective of ExamPrep is to provide a structured examination-practice system while demonstrating Java programming concepts including classes and objects, encapsulation, packages, collections, file handling, exception handling, and modular programming.
