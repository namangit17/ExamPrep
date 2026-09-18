# ExamPrep – Project Statement

## Project Title

ExamPrep – Multi-Subject Question Bank & Practice System

## Problem Statement

Students often use different sources to practice questions from multiple subjects. This can make question practice, score tracking, and revision difficult to manage in one place.

ExamPrep provides a single console-based application where students can browse questions, take randomized practice tests, view previous results, and revise incorrectly answered questions.

## Scope of the Project

The project covers a console-based MCQ practice system for four academic subjects. It provides question browsing, subject and module-based filtering, randomized practice tests, result storage, revision of incorrectly answered questions, and basic administrative question management.

The system uses Java and text files for implementation and storage.

## Target Users

- College students preparing for academic examinations.
- Teachers or administrators managing the question bank.

## Objectives

- Provide a structured question bank for multiple subjects.
- Allow students to practice randomized MCQ tests.
- Calculate and store test results.
- Store incorrectly answered questions for revision.
- Provide basic question management through an admin section.
- Organize questions according to subject, module, and difficulty.

## Subjects

1. Java Programming
2. Operating Systems
3. Discrete Mathematics
4. Digital Logic and Computer Architecture

The question bank contains 800 questions, with 200 questions for each subject.

## High-Level Features

- Browse and filter questions.
- Take randomized MCQ tests.
- Calculate test scores.
- Store previous results.
- Review incorrectly answered questions.
- Add and delete questions through the admin section.

## Functional Modules

### Module 1 – Question Bank

- View all questions.
- View questions by subject.
- View questions by module.
- View questions by difficulty.

### Module 2 – Practice Test

- Select subject.
- Select module.
- Select number of questions.
- Attempt randomized MCQs.
- Calculate final score.

### Module 3 – Results & Performance

- Save test results.
- View previous results.
- View correct answers.
- View percentage scores.

### Module 4 – Revision

- Store incorrectly answered question IDs.
- View incorrectly answered questions.
- Review correct answers.

### Module 5 – Admin / Question Management

- Add questions.
- Delete questions.
- View the question bank.

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

The application uses standard Java libraries and lightweight text files.

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

### questions.txt

Stores the complete question bank.

### results.txt

Stores previous test results.

### wrong_questions.txt

Stores IDs of incorrectly answered questions.

## System Workflow

```text
Start
  ↓
Main Menu
  ↓
Question Bank / Practice Test / Results / Revision / Admin
  ↓
User Selection
  ↓
Process Request
  ↓
Read or Write Data
  ↓
Display Output
  ↓
Return to Main Menu