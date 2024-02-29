package my.yongblog.domain.leave;

import jakarta.persistence.*;
import lombok.Getter;
import my.yongblog.domain.base.BaseTimeEntity;
import my.yongblog.domain.user.Yong;

@Entity
@Table(name = "yong_leave")
@Getter
public class Leave extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private Long id;
    @OneToOne(mappedBy = "leave")
    private Yong user;
    private Integer UsedDays;
    private Integer RemainingDays;
}
