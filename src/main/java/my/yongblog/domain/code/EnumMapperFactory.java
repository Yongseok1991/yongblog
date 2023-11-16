package my.yongblog.domain.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Getter
public class EnumMapperFactory {
    private final Map<String, List<EnumMapperValue>> factory;
    public EnumMapperFactory(Map<String, List<EnumMapperValue>> factory) {
        this.factory = factory;
    }
    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key, this.toEnumValues(e));
    }

    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(EnumMapperValue::new)
                .toList();
    }


}
