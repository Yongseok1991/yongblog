package my.yongblog.domain.approve;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.user.Yong;

import java.util.List;

@Entity
@Table(name = "yong_document")
@Getter
@NoArgsConstructor
public class Document extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Yong author;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private ApprovalType approvalType;

    @Enumerated(EnumType.STRING)
    private DocumentStatus status;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<ApprovalLine> approvalLines;
}
