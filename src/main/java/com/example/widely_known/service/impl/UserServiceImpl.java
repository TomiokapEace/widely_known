package com.example.widely_known.service.impl;
import java.util.List;
import com.example.widely_known.entity.pojo.User;
import com.example.widely_known.entity.vo.UserVo;
import com.example.widely_known.entity.dto.UserDto;
import com.example.widely_known.mapper.UserMapper;
import com.example.widely_known.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final QueryWrapper<User> queryWrapper = new QueryWrapper<>();

    public boolean updateUserById(User entity){
        return this.getBaseMapper().updateById(entity)==1;
    }

    public boolean insertUser(User entity){
        return this.getBaseMapper().insert(entity)==1;
    }

    public boolean deleteUser(List<String> ids){
        for (String id : ids) {
        if(this.getBaseMapper().deleteById(id)!=1)
            return false;
        }
        return true;
    }

    public List<User> queryUserListById(List<String> ids){
        queryWrapper.clear();
        for (int i = 0; i < ids.size(); i++) {
            queryWrapper.eq("id",ids.get(i));
        if (i!=ids.size()-1)
            queryWrapper.or();
        }
        List<User> selectList = this.getBaseMapper().selectList(queryWrapper);
        return selectList;
    }

    public Page<User> queryUserPage(Integer current,Integer size){
        queryWrapper.clear();
        return queryUserPage(current,size,queryWrapper);
    }

    public Page<User> queryUserPage(Integer current,Integer size,QueryWrapper<User> queryWrapper){
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListById(String value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListById(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByName(String value){
        queryWrapper.clear();
        queryWrapper.eq("name",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByName(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("name",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByUsername(String value){
        queryWrapper.clear();
        queryWrapper.eq("username",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByUsername(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("username",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByPassword(String value){
        queryWrapper.clear();
        queryWrapper.eq("password",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByPassword(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("password",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByEmail(String value){
        queryWrapper.clear();
        queryWrapper.eq("email",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByEmail(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("email",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByCreateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByCreateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByUpdateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByUpdateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
    public List<User> queryUserListByIsAdmin(Boolean value){
        queryWrapper.clear();
        queryWrapper.eq("isAdmin",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<User> queryUserListByIsAdmin(Integer current,Integer size,Boolean value){
        queryWrapper.clear();
        queryWrapper.eq("isAdmin",value);
        return this.getBaseMapper().selectPage(new Page<User>(current,size),queryWrapper);
    }
}
