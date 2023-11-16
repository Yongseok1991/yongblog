package my.yongblog.domain.code.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import my.yongblog.domain.code.EnumMapperType;

@RequiredArgsConstructor
public enum Use implements EnumMapperType {
    USED("사용중"),
    DISABLED("비활성화");
    @Getter
    private final String title;
    @Override
    public String getCode() {
        return name();
    }
}
