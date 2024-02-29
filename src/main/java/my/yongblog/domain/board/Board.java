package my.yongblog.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;

@Entity
@Getter
@Table(name = "yong_board")
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;
    private String title;
    private boolean isAttached;
    private Integer attachCount;
    private boolean isAnswer;
}
