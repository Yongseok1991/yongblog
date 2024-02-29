package my.yongblog.domain.file;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.board.Post;
import my.yongblog.domain.user.Yong;

@Entity
@Table(name = "yong_file")
@NoArgsConstructor
@Getter
public class File extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Yong user;

    private String fileName;

    private String filePath;
}
