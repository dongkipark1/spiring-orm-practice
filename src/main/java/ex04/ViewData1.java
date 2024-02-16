package ex04;



import ex04.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ViewData1 {
    private int boardId;
    private String title;
    private String content;

    private User user;

    public ViewData1(DBData1 dbData) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.user = new User(dbData.getUserId(), dbData.getUsername(), dbData.getEmail());
    }
    
}
