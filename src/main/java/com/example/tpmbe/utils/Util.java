package com.example.tpmbe.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class Util {

    public List<String> getColumnNames(Class<?> className) {
        List<String> columnNames = new ArrayList<>();
        Field[] fields = className.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getSimpleName().equals("Column")) {
                   columnNames.add(field.getName());
                }
            }
        }

        return columnNames;
    }

    public <T> Map<String, List<String>> groupByPosition(List<T> data,
                                                         Function<T, String> keyExtractor,
                                                         Function<T, String> valueExtractor
    ) {
        Map<String, List<String>> groupedData = new HashMap<>();

        for (T item : data) {
            String key = keyExtractor.apply(item);
            String value = valueExtractor.apply(item);

            if (groupedData.containsKey(key)) {
                groupedData.get(key).add(value);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(value);
                groupedData.put(key, valueList);
            }
        }

        return groupedData;
    }

}
