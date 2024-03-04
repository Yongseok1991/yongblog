package my.yongblog.domain.sch;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;

@Entity
@Getter
@Table(name = "yong_schedule")
@NoArgsConstructor
public class YongSchedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;
    private String title;
    private String content;
    private String schStartDate;
    private String schLastDate;
}
