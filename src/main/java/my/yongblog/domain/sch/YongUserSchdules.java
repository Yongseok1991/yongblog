package my.yongblog.domain.sch;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.user.Yong;

@Entity
@Getter
@Table(name = "Yong_user_schdules")
@NoArgsConstructor
public class YongUserSchdules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_schdules_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private YongSchedule schedule;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Yong user;
}
