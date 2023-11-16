package my.yongblog.domain.code.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import my.yongblog.domain.code.EnumMapperType;

@RequiredArgsConstructor
public enum Status implements EnumMapperType {
    READY("준비 중"),
    PROCEEDING("진행 중"),
    COMPLETE("완료");
    @Getter
    private final String title;
    @Override
    public String getCode() {
        return name();
    }
}
