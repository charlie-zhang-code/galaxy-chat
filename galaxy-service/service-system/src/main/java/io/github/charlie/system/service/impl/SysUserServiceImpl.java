package io.github.charlie.system.service.impl;

import io.github.charlie.system.model.entity.SysUser;
import io.github.charlie.system.mapper.SysUserMapper;
import io.github.charlie.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Charlie Zhang
 * @since 2025-06-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
