package my.yongblog.domain.approve.document;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.approve.Document;
import my.yongblog.domain.leave.LeaveType;

@Entity
@Table(name = "docu_leave")
@Getter
@NoArgsConstructor
@DiscriminatorValue("LEAVE")
public class DocuLeave extends Document{
    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    private String leaveStartDate;
    private String leaveLastDate;
    private Integer usedLeaveCount;
}
