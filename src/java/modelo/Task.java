package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {

    private int taskId;
    private String title;
    private String description;
    private TaskStatus status; // Enum for task status
    private LocalDate dueDate;
    private TaskPriority priority; // Enum for task priority
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int userId; // Foreign key to associate with User

    // Constructor
    public Task(int taskId, String title, String description, TaskStatus status,
            LocalDate dueDate, TaskPriority priority, LocalDateTime createdAt,
            LocalDateTime updatedAt, int userId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    // Getters and setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{"
                + "taskId=" + taskId
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", status=" + status
                + ", dueDate=" + dueDate
                + ", priority=" + priority
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", userId=" + userId
                + '}';
    }
}
