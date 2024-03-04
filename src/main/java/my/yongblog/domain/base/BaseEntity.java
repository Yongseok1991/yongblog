package my.yongblog.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@EntityListeners(value = {AuditingEntityListener.class}) // Auditing 적용 에너테이션
@MappedSuperclass // 공통 매핑 정보가 필요할 때 사용 -> 부모 클래스를 상속받는 자식 클래서에 매핑 정보만 제공
public class BaseEntity extends BaseTimeEntity {

    @CreatedBy
    @Column(updatable = false)
    private Long createdId;

    @LastModifiedBy
    private Long updatedId;
}
