package my.yongblog.domain.approve;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.approve.document.DocuLeave;
import my.yongblog.domain.user.Yong;

import java.util.List;

@Entity
@Table(name = "yong_document")
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DOCUMENT_TYPE")
public abstract class Document extends BaseTimeEntity {
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
    private DocumentStatus status;

    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private DocuLeave docuLeave;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<ApprovalLine> approvalLines;
}
