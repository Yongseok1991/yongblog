package my.yongblog.domain.leave;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.user.Yong;

@Entity
@Table(name = "user_leave")
@Getter
@NoArgsConstructor
public class UserLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_leave_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Yong yong;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String leaveStartDate;
    private String leaveLastDate;
    private Integer usedLeaveCount;
}
