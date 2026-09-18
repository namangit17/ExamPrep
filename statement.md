# ExamPrep – Project Statement

## Project Title

ExamPrep – Multi-Subject Question Bank & Practice System

## Problem Statement

Students often use different sources to practice questions from multiple subjects. This can make question practice, score tracking, and revision difficult to manage in one place.

ExamPrep provides a single console-based application where students can browse questions, take randomized practice tests, view previous results, and revise incorrectly answered questions.

## Objectives

- Provide a structured question bank for multiple subjects.
- Allow students to practice randomized MCQ tests.
- Calculate and store test results.
- Store incorrectly answered questions for revision.
- Provide basic question management through an admin section.
- Organize questions according to subject, module, and difficulty.

## Subjects

The system contains question banks for:

1. Java Programming
2. Operating Systems
3. Discrete Mathematics
4. Digital Logic and Computer Architecture

The question bank contains 800 questions, with 200 questions for each subject.

## Functional Modules

### Module 1 – Question Bank

Allows students to:

- View all questions.
- View questions by subject.
- View questions by module.
- View questions by difficulty.

### Module 2 – Practice Test

Allows students to:

- Select a subject.
- Select a module.
- Select the number of questions.
- Attempt randomized MCQs.
- Calculate the final score.

### Module 3 – Results & Performance

Allows students to:

- Save test results.
- View previous results.
- View number of questions attempted.
- View correct answers.
- View percentage scores.

### Module 4 – Revision

Allows students to:

- Store incorrectly answered question IDs.
- View incorrectly answered questions.
- Review the correct answers.

### Module 5 – Admin / Question Management

Allows the administrator to:

- Add questions.
- Delete questions.
- View the complete question bank.

## Non-Functional Requirements

### Usability

The application provides a simple menu-driven console interface.

### Reliability

Invalid user input is handled through validation and exception handling.

### Maintainability

The application is divided into multiple classes with separate responsibilities.

### Performance

Questions are loaded into an ArrayList and filtered according to user requirements.

### Resource Efficiency

The application uses standard Java libraries and lightweight text files instead of a database.

## Technology Used

- Java
- Object-Oriented Programming
- ArrayList
- File Handling
- Exception Handling
- Collections.shuffle()
- Java Packages
- Text File Storage

## Data Storage

The application stores data in text files:

- `questions.txt` – stores the question bank.
- `results.txt` – stores test results.
- `wrong_questions.txt` – stores incorrectly answered question IDs.

## System Workflow

```text
Start
  ↓
Main Menu
  ↓
┌───────────────────────────────┐
│ Question Bank                 │
│ Practice Test                 │
│ Results & Performance         │
│ Revision                      │
│ Admin / Question Management   │
└───────────────────────────────┘
  ↓
User Selection
  ↓
Process Request
  ↓
Read / Write Data
  ↓
Display Output
  ↓
Return to Main Menu