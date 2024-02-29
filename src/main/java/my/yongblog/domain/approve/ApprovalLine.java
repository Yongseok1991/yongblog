package my.yongblog.domain.approve;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.user.Yong;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "yong_approval_line")
public class ApprovalLine extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_line_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Yong approver;

    private String comment;
    @Column
    private Integer orderNum;
}
