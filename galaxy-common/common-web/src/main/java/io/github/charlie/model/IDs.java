package io.github.charlie.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description 批量删除ID，增加批量ID
 */
@Data
public class IDs implements Serializable {
    private List<Long> ids;
}
