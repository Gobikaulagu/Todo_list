import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser = null;
    private static TodoList todoList = new TodoList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (currentUser == null) {
                showAuthMenu();
            } else {
                showTodoMenu();
            }
        }
    }

    private static void showAuthMenu() {
        System.out.println("\n=== Todo List Application ===");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                break;
            case 3:
                System.out.println("Thank you for using Todo List Application!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void showTodoMenu() {
        System.out.println("\n=== Todo List Menu ===");
        System.out.println("1. Add Todo");
        System.out.println("2. Remove Todo");
        System.out.println("3. Mark Todo as Completed");
        System.out.println("4. Update Todo");
        System.out.println("5. List All Todos");
        System.out.println("6. List Todos by Category");
        System.out.println("7. List Pending Todos");
        System.out.println("8. List Completed Todos");
        System.out.println("9. View Categories");
        System.out.println("10. Logout");
        System.out.print("Enter your choice (1-10): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addTodo();
                break;
            case 2:
                removeTodo();
                break;
            case 3:
                markAsCompleted();
                break;
            case 4:
                updateTodo();
                break;
            case 5:
                todoList.listAllTodos(currentUser.getUsername());
                break;
            case 6:
                listByCategory();
                break;
            case 7:
                todoList.listPendingTodos(currentUser.getUsername());
                break;
            case 8:
                todoList.listCompletedTodos(currentUser.getUsername());
                break;
            case 9:
                todoList.listCategories();
                break;
            case 10:
                logout();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            currentUser.setLoggedIn(true);
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private static void signUp() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("Sign up successful! Please login.");
    }

    private static void logout() {
        if (currentUser != null) {
            currentUser.setLoggedIn(false);
            currentUser = null;
            System.out.println("Logged out successfully!");
        }
    }

    private static void addTodo() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        
        todoList.listCategories();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        todoList.addTodo(title, description, category, currentUser.getUsername());
    }

    private static void removeTodo() {
        System.out.print("Enter todo ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        todoList.removeTodo(id, currentUser.getUsername());
    }

    private static void markAsCompleted() {
        System.out.print("Enter todo ID to mark as completed: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        todoList.markAsCompleted(id, currentUser.getUsername());
    }

    private static void updateTodo() {
        System.out.print("Enter todo ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        
        todoList.listCategories();
        System.out.print("Enter new category: ");
        String category = scanner.nextLine();

        todoList.updateTodo(id, title, description, category, currentUser.getUsername());
    }

    private static void listByCategory() {
        todoList.listCategories();
        System.out.print("Enter category to view: ");
        String category = scanner.nextLine();
        todoList.listTodosByCategory(category, currentUser.getUsername());
    }
} 