package my.yongblog.domain.pos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;

@Entity
@Getter
@Table(name = "yong_position")
@NoArgsConstructor
public class YongPosition extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;
    private String name;
}
