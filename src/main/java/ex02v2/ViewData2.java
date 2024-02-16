package ex02v2;

import ex02v2.model.Reply;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ViewData2 {
    private int boardId;
    private String title;
    private String content;
    private int replyId;
    private String comment;

    // Board 데이터만 넣는 생성자

    public ViewData2(List<DBData2> dbList) {
        if (dbList.size() > 0) {
            this.boardId = dbList.get(0).getBoardId();
            this.title = dbList.get(0).getTitle();
            this.content = dbList.get(0).getComment();
        }
        // 방법 1
        for(DBData2 data : dbList){
            Reply r = new Reply(data.getReplyId(), data.getComment());
            addReply(r);
        }
          // 방법 2
//        dbList.stream().forEach(data -> {
//            addReply(new Reply(data.getReplyId(), data.getComment()));
//        });

        replies = dbList.stream().map(data -> new Reply(data.getReplyId(), data.getComment())).toList();
    }


    // 댓글들은 addReply로 추가하기
    private List<Reply> replies = new ArrayList<>();

    public void addReply(Reply reply){
        replies.add(reply);
    }


}
