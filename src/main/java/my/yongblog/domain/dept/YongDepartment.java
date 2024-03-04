package my.yongblog.domain.dept;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.yongblog.domain.base.BaseEntity;

@Entity
@Getter
@Table(name = "yong_department")
@NoArgsConstructor
public class YongDepartment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    private String name;
}
