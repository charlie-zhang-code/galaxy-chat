package io.github.charlie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 22/04/2025
 * @description 下拉选项对象
 */
@Data
@NoArgsConstructor
public class ValueName<T> implements Serializable {

    private T value;

    private String name;

    private List<ValueName<T>> children;

    public ValueName(T value, String name) {
        this.value = value;
        this.name = name;
    }

    public ValueName(T value, String name, List<ValueName<T>> children) {
        this.value = value;
        this.name = name;
        this.children = children;
    }
}
