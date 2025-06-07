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
 * 用户表
 * </p>
 *
 * @author Charlie Zhang
 * @since 2025-06-02
 */
@Data
@TableName("sys_user")
@Schema(name = "SysUser", description = "用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识符，主键
     */
    @Schema(description = "用户唯一标识符，主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户登录时使用的用户名
     */
    @Schema(description = "用户登录时使用的用户名")
    private String username;

    /**
     * 用户账户的密码，应存储加密后的值
     */
    @Schema(description = "用户账户的密码，应存储加密后的值")
    private String password;

    /**
     * 用户在系统中显示的名字，可选
     */
    @Schema(description = "用户在系统中显示的名字，可选")
    private String nickname;

    /**
     * 用户头像的URL或路径
     */
    @Schema(description = "用户头像的URL或路径")
    private String avatar;

    /**
     * 用户背景图片的URL或路径
     */
    @Schema(description = "用户背景图片的URL或路径")
    private String background;

    /**
     * 用户设置的个人座右铭或签名
     */
    @Schema(description = "用户设置的个人座右铭或签名")
    private String quote;

    /**
     * 用户的性别，0表示保密，1表示男性，2表示女性
     */
    @Schema(description = "用户的性别，0表示保密，1表示男性，2表示女性")
    private Integer gender;

    /**
     * 用户的电子邮件地址，可用于找回密码或接收通知
     */
    @Schema(description = "用户的电子邮件地址，可用于找回密码或接收通知")
    private String email;

    /**
     * 用户的联系电话，可用于身份验证或联系用户
     */
    @Schema(description = "用户的联系电话，可用于身份验证或联系用户")
    private String telephone;

    /**
     * 状态，0表示禁用，1表示正常启用
     */
    @Schema(description = "状态，0表示禁用，1表示正常启用")
    private Boolean status;
}
