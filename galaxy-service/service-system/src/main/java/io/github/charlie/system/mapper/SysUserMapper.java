package io.github.charlie.system.mapper;

import io.github.charlie.system.model.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Charlie Zhang
 * @since 2025-06-02
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}

