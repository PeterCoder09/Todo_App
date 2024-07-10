package dao;

import conexion.Conexion;
import modelo.Task;
import modelo.TaskPriority;
import modelo.TaskStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    // Método para obtener todas las tareas
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tasks";
        try (Connection conn = Conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int taskId = rs.getInt("task_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                TaskStatus status = TaskStatus.valueOf(rs.getString("status").toUpperCase());
                LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                TaskPriority priority = TaskPriority.valueOf(rs.getString("priority").toUpperCase());
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                int userId = rs.getInt("user_id");

                // Map ResultSet to Task object
                Task task = new Task(taskId, title, description, status, dueDate, priority, createdAt, updatedAt, userId);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Método para obtener una tarea por su ID
    public Task getTaskById(int taskId) {
        String sql = "SELECT * FROM Tasks WHERE task_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, taskId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    TaskStatus status = TaskStatus.valueOf(rs.getString("status").toUpperCase());
                    LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                    TaskPriority priority = TaskPriority.valueOf(rs.getString("priority").toUpperCase());
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                    int userId = rs.getInt("user_id");

                    // Map ResultSet to Task object
                    return new Task(taskId, title, description, status, dueDate, priority, createdAt, updatedAt, userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no task found
    }

    // Método para agregar una nueva tarea
    public boolean addTask(Task task) {
        String sql = "INSERT INTO Tasks (title, description, status, due_date, priority, created_at, updated_at, user_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus().toString().toUpperCase());
            stmt.setDate(4, java.sql.Date.valueOf(task.getDueDate()));
            stmt.setString(5, task.getPriority().toString().toUpperCase());
            stmt.setObject(6, LocalDateTime.now());
            stmt.setObject(7, LocalDateTime.now());
            stmt.setInt(8, task.getUserId());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar una tarea existente
    public boolean updateTask(Task task) {
        String sql = "UPDATE Tasks SET title = ?, description = ?, status = ?, due_date = ?, priority = ?, updated_at = ?, user_id = ? "
                + "WHERE task_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus().toString().toUpperCase());
            stmt.setDate(4, java.sql.Date.valueOf(task.getDueDate()));
            stmt.setString(5, task.getPriority().toString().toUpperCase());
            stmt.setObject(6, LocalDateTime.now());
            stmt.setInt(7, task.getUserId());
            stmt.setInt(8, task.getTaskId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para eliminar lógicamente una tarea (marcar como inactiva)
    public boolean deleteTask(int taskId) {
        String sql = "DELETE FROM Tasks WHERE task_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, taskId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para obtener las tareas por userId
    public List<Task> getTasksByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM Tasks WHERE user_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            System.out.println("Executing query: " + stmt); // Depuración
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int taskId = rs.getInt("task_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    TaskStatus status = TaskStatus.valueOf(rs.getString("status").toUpperCase());
                    LocalDate dueDate = rs.getDate("due_date").toLocalDate();
                    TaskPriority priority = TaskPriority.valueOf(rs.getString("priority").toUpperCase());
                    LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();

                    Task task = new Task(taskId, title, description, status, dueDate, priority, createdAt, updatedAt, userId);
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}
