package com.example.widely_known.service;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.example.widely_known.entity.pojo.User;
import com.example.widely_known.entity.vo.UserVo;
import com.example.widely_known.entity.dto.UserDto;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author  
 * @since 2024-05-22
 */
public interface UserService extends IService<User> {

    boolean updateUserById(User entity);

    boolean insertUser(User entity);

    boolean deleteUser(List<String> ids);

    List<User> queryUserListById(List<String> ids);

    Page<User> queryUserPage(Integer current,Integer size);

    Page<User> queryUserPage(Integer current,Integer size,QueryWrapper<User> queryWrapper);

    List<User> queryUserListById(String value);

    Page<User> queryUserListById(Integer current,Integer size,String value);

    List<User> queryUserListByName(String value);

    Page<User> queryUserListByName(Integer current,Integer size,String value);

    List<User> queryUserListByUsername(String value);

    Page<User> queryUserListByUsername(Integer current,Integer size,String value);

    List<User> queryUserListByPassword(String value);

    Page<User> queryUserListByPassword(Integer current,Integer size,String value);

    List<User> queryUserListByEmail(String value);

    Page<User> queryUserListByEmail(Integer current,Integer size,String value);

    List<User> queryUserListByCreateTime(LocalDateTime value);

    Page<User> queryUserListByCreateTime(Integer current,Integer size,LocalDateTime value);

    List<User> queryUserListByUpdateTime(LocalDateTime value);

    Page<User> queryUserListByUpdateTime(Integer current,Integer size,LocalDateTime value);

    List<User> queryUserListByIsAdmin(Boolean value);

    Page<User> queryUserListByIsAdmin(Integer current,Integer size,Boolean value);

}
