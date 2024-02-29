package my.yongblog.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.user.Yong;

@Table(name = "yong_comment")
@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Yong user;

    private String content;

}
