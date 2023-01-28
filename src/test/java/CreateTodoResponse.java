import java.util.Date;

public record CreateTodoResponse(String id, String title, TodoStatus status, Date createdAt, Date updatedAt) {
}