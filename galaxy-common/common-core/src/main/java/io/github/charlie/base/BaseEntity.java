package io.github.charlie.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description 基础实体类
 */
@Data
public class BaseEntity implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private Date createAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
