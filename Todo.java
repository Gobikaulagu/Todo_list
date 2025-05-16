public class Todo {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private String category;
    private String username; // To associate todos with users

    public Todo(int id, String title, String description, String category, String username) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.category = category;
        this.username = username;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nDescription: " + description + 
               "\nCategory: " + category +
               "\nStatus: " + (completed ? "Completed" : "Pending") + "\n";
    }
} 