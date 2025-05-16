# Todo List Application

## Introduction
The Todo List Application is a command-line based task management system designed to help users organize and track their daily tasks efficiently. This application provides a simple yet powerful interface for managing personal and professional tasks, making it easier for users to stay organized and productive.

## Abstract
This project implements a task management system that allows users to create, update, and track their tasks through a user-friendly command-line interface. The application uses object-oriented programming principles to maintain a clean and modular codebase, making it easy to extend and maintain. The system is designed to be intuitive and efficient, requiring minimal learning curve for new users.

## Framework
The application is built using:
- **Java Programming Language**: Core implementation language
- **Object-Oriented Design**: For better code organization and maintainability
- **Command-Line Interface**: For simple and efficient user interaction
- **In-Memory Data Storage**: For task management during runtime

## Modules

### 1. User Interface Module
- Handles all user interactions
- Provides a menu-driven interface
- Manages user input validation
- Displays task information in a readable format

### 2. Task Management Module
- Core functionality for task operations
- Handles task creation, modification, and deletion
- Manages task status (completed/pending)
- Maintains task organization

### 3. Data Management Module
- Manages task data structure
- Handles task ID generation
- Maintains task collection
- Provides data filtering capabilities

## Features
- Task Creation: Add new tasks with title and description
- Task Modification: Update existing task details
- Task Status: Mark tasks as completed
- Task Organization: View tasks by status (all/pending/completed)
- Task Deletion: Remove unwanted tasks
- User-Friendly Interface: Simple menu-driven system

## Screenshots
[Note: Add screenshots of your application in action here]
1. Main Menu Interface
2. Adding a New Task
3. Viewing Task List
4. Marking Tasks as Completed

## Results
The Todo List Application successfully provides:
- Efficient task management
- Clear task organization
- Easy task tracking
- Intuitive user interface
- Reliable task status management

## Future Scope
- Implementation of data persistence
- Addition of task categories
- Priority levels for tasks
- Due date functionality
- Search and filter capabilities
- Task sorting options

## Conclusion
The Todo List Application demonstrates effective implementation of a task management system using Java. It provides essential features for task organization while maintaining simplicity and usability. The modular design allows for easy extension and maintenance, making it a solid foundation for future enhancements.

## Requirements
- Java Runtime Environment (JRE) 8 or higher
- Java Development Kit (JDK) for compilation

## Steps to Run

### Prerequisites
1. Install Java Development Kit (JDK)
   - Download JDK from Oracle's website or use OpenJDK
   - Set up JAVA_HOME environment variable
   - Add Java to system PATH

2. Verify Java Installation
   ```bash
   java -version
   javac -version
   ```

### Running the Application

1. **Clone or Download the Project**
   - Download the project files to your local machine
   - Extract the files if downloaded as a zip

2. **Navigate to Project Directory**
   ```bash
   cd path/to/Todo-List-Application
   ```

3. **Compile the Java Files**
   ```bash
   javac *.java
   ```
   This will create the following class files:
   - Main.class
   - Todo.class
   - TodoList.class

4. **Run the Application**
   ```bash
   java Main
   ```

5. **Using the Application**
   - The main menu will appear with options 1-8
   - Follow the on-screen prompts to:
     - Add new tasks (Option 1)
     - Remove tasks (Option 2)
     - Mark tasks as completed (Option 3)
     - Update tasks (Option 4)
     - View all tasks (Option 5)
     - View pending tasks (Option 6)
     - View completed tasks (Option 7)
     - Exit the application (Option 8)

### Troubleshooting Common Issues

1. **Compilation Errors**
   - Ensure all Java files are in the same directory
   - Verify Java installation and PATH settings
   - Check for syntax errors in the code

2. **Runtime Errors**
   - Make sure all class files are present
   - Verify you're in the correct directory
   - Check for proper file permissions

3. **Input Issues**
   - Use numbers 1-8 for menu options
   - Enter valid text for task titles and descriptions
   - Use existing task IDs for operations
