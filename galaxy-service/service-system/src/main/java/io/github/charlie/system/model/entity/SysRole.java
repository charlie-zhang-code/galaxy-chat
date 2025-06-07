package io.github.charlie.system.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.charlie.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Data;
/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Charlie Zhang
 * @since 2025-06-02
 */
@Data
@TableName("sys_role")
@Schema(name = "SysRole", description = "角色表")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称")
    private String name;

    /**
     * 角色编码，一旦创建后不允许修改
     */
    @Schema(description = "角色编码，一旦创建后不允许修改")
    private String code;

    /**
     * 角色权限范围，1全部数据权限 2自定数据权限 3本用户组数据权限 4本用户组及以下数据权限 5本人
     */
    @Schema(description = "角色权限范围，1全部数据权限 2自定数据权限 3本用户组数据权限 4本用户组及以下数据权限 5本人")
    private Integer scope;

    /**
     * 状态，0表示禁用，1表示正常启用
     */
    @Schema(description = "状态，0表示禁用，1表示正常启用")
    private Boolean status;
}
