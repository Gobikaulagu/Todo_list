import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private List<Todo> todos;
    private int nextId;
    private static final String[] CATEGORIES = {
        "Work", "Home", "Grocery", "Movies to Watch", 
        "Places to Eat", "Personal", "Other"
    };

    public TodoList() {
        todos = new ArrayList<>();
        nextId = 1;
    }

    public void addTodo(String title, String description, String category, String username) {
        if (!isValidCategory(category)) {
            System.out.println("Invalid category! Please choose from: " + String.join(", ", CATEGORIES));
            return;
        }
        Todo todo = new Todo(nextId++, title, description, category, username);
        todos.add(todo);
        System.out.println("Todo added successfully!");
    }

    public void removeTodo(int id, String username) {
        todos.removeIf(todo -> todo.getId() == id && todo.getUsername().equals(username));
        System.out.println("Todo removed successfully!");
    }

    public void markAsCompleted(int id, String username) {
        for (Todo todo : todos) {
            if (todo.getId() == id && todo.getUsername().equals(username)) {
                todo.setCompleted(true);
                System.out.println("Todo marked as completed!");
                return;
            }
        }
        System.out.println("Todo not found!");
    }

    public void updateTodo(int id, String title, String description, String category, String username) {
        if (!isValidCategory(category)) {
            System.out.println("Invalid category! Please choose from: " + String.join(", ", CATEGORIES));
            return;
        }
        for (Todo todo : todos) {
            if (todo.getId() == id && todo.getUsername().equals(username)) {
                todo.setTitle(title);
                todo.setDescription(description);
                todo.setCategory(category);
                System.out.println("Todo updated successfully!");
                return;
            }
        }
        System.out.println("Todo not found!");
    }

    public void listAllTodos(String username) {
        List<Todo> userTodos = todos.stream()
            .filter(todo -> todo.getUsername().equals(username))
            .collect(Collectors.toList());

        if (userTodos.isEmpty()) {
            System.out.println("No todos in the list!");
            return;
        }
        System.out.println("\n=== Todo List ===");
        for (Todo todo : userTodos) {
            System.out.println(todo);
        }
    }

    public void listTodosByCategory(String category, String username) {
        List<Todo> categoryTodos = todos.stream()
            .filter(todo -> todo.getCategory().equals(category) && todo.getUsername().equals(username))
            .collect(Collectors.toList());

        if (categoryTodos.isEmpty()) {
            System.out.println("No todos in category: " + category);
            return;
        }
        System.out.println("\n=== " + category + " Todos ===");
        for (Todo todo : categoryTodos) {
            System.out.println(todo);
        }
    }

    public void listPendingTodos(String username) {
        List<Todo> pendingTodos = todos.stream()
            .filter(todo -> !todo.isCompleted() && todo.getUsername().equals(username))
            .collect(Collectors.toList());

        if (pendingTodos.isEmpty()) {
            System.out.println("No pending todos!");
            return;
        }
        System.out.println("\n=== Pending Todos ===");
        for (Todo todo : pendingTodos) {
            System.out.println(todo);
        }
    }

    public void listCompletedTodos(String username) {
        List<Todo> completedTodos = todos.stream()
            .filter(todo -> todo.isCompleted() && todo.getUsername().equals(username))
            .collect(Collectors.toList());

        if (completedTodos.isEmpty()) {
            System.out.println("No completed todos!");
            return;
        }
        System.out.println("\n=== Completed Todos ===");
        for (Todo todo : completedTodos) {
            System.out.println(todo);
        }
    }

    public void listCategories() {
        System.out.println("\nAvailable Categories:");
        for (String category : CATEGORIES) {
            System.out.println("- " + category);
        }
    }

    private boolean isValidCategory(String category) {
        for (String validCategory : CATEGORIES) {
            if (validCategory.equals(category)) {
                return true;
            }
        }
        return false;
    }
} 