package my.yongblog.domain.code;

import lombok.Getter;

@Getter
public class EnumMapperValue {

    private String code;
    private String title;

    public EnumMapperValue(EnumMapperType type) {
        this.code = type.getCode();
        this.title = type.getTitle();
    }
}
