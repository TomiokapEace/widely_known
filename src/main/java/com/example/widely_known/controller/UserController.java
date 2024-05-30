package com.example.widely_known.controller;
import com.example.widely_known.utils.StringUtils;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.fastjson2.JSONObject;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.lang.reflect.Field;
import com.example.widely_known.entity.pojo.User;
import com.example.widely_known.entity.vo.UserVo;
import com.example.widely_known.entity.dto.UserDto;
import com.example.widely_known.service.UserService;
import com.example.widely_known.utils.HttpStatus;
import com.example.widely_known.entity.vo.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import static com.alibaba.fastjson2.JSONReader.Feature.IgnoreNoneSerializable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
/**
* <p>
    * User 前端控制器
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Api(tags="相关接口")
@RestController
@RequestMapping("/api/widely_known/user")
public class UserController {
    @Autowired
    private UserService UserService;
    @Resource
    private Cache<String,Object> caffeineCache;
    private final String permission_prefix="widely_known:user:";
    @PostMapping("/retrieve")
    public R retrieve(@RequestBody UserDto userDto){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",userDto.getUsername()).eq("email",userDto.getEmail()).eq("name",userDto.getName());
        User user = null;
        try {
            user = UserService.getBaseMapper().selectOne(wrapper);
        } catch (Exception e) {
            return R.fail("账号不存在失败");
        }
        if (user!=null) {
            user.setPassword(userDto.getPassword());
            UserService.updateUserById(user);
            return R.ok("账号找回成功");
        }
        return R.fail("账号找回失败");
    }
    @GetMapping("/login")
    public R login(@RequestParam("username") String username,@RequestParam("password") String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);
        User user = null;
        try {
            user = UserService.getBaseMapper().selectOne(wrapper);
        } catch (Exception e) {
            return R.fail("登录失败");
        }
        if (user!=null) {
            caffeineCache.put(user.getId(),user);
            user.setPassword("");
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            return R.ok(userVo);
        }
        return R.fail("登录失败");
    }
    @GetMapping("/logout")
    public R logout(@RequestParam("user_id") String user_id){
        try {
            caffeineCache.asMap().remove(user_id);
        } catch (Exception e) {
            return R.fail(e);
        }
        return R.ok();
    }
    @PostMapping("/select")
    @Operation(summary ="条件查询User类")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name="User",value="User实体类",dataTypeClass = User.class,paramType = "body"),
                    @ApiImplicitParam(name="current",value="当前页",dataTypeClass = Integer.class,paramType = "body"),
                    @ApiImplicitParam(name="size",value="页数大小",dataTypeClass = Integer.class,paramType = "body")
            }
    )
    public R select(@RequestBody JSONObject jsonObject) throws ClassNotFoundException {
        Integer current =(Integer)jsonObject.get("current");
        Integer size = (Integer) jsonObject.get("pageSize");
        boolean exact = jsonObject.getBooleanValue("exact",false);
        jsonObject.remove("exact");
        jsonObject.remove("current");
        jsonObject.remove("pageSize");
        jsonObject.remove("created_at");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Field[] fields = User.class.getDeclaredFields();
        if (jsonObject.size()>0)
            for (int i = 0; i < fields.length; i++) {
                Field field=fields[i];
                String field_str= StringUtils.formattedVariable(field.getName());
                if (jsonObject.getString(field_str)!=null&&jsonObject.getString(field_str)!="") {
                    if (exact) {
                        wrapper.eq(field_str, jsonObject.getString(field_str));
                    }else {
                        wrapper.like(field_str, jsonObject.getString(field_str));
                    }
                }
            }
        Page<User> UserPage =null;
        try {
            UserPage = UserService.queryUserPage(current, size, wrapper);
        }catch (Exception e){
            UserPage = UserService.queryUserPage(current, size);
            return R.ok(UserPage);
        }
        return R.ok(UserPage);
    }
    @PostMapping("/add")
    @Operation(summary ="添加User类")
    @ApiImplicitParam(name="form",value="User实体类",dataTypeClass = User.class,paramType = "body")
    public R Add(@Valid @RequestBody UserDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
            return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        User pojoEntity = new User();
        BeanUtils.copyProperties(entity,pojoEntity);
        return UserService.insertUser(pojoEntity)?R.ok():R.fail();
    }

    @PostMapping("/update")
    @Operation(summary ="按id修改User类")
    @ApiImplicitParam(name="form",value="User实体类",dataTypeClass = User.class,paramType = "body")
    public R Update(@Valid @RequestBody UserDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
                return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        User pojoEntity = new User();
        BeanUtils.copyProperties(entity,pojoEntity);
        return UserService.updateUserById(pojoEntity)?R.ok():R.fail();
    }
    @GetMapping("/deleted")
    @Operation(summary ="按id删除User类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R deleted(@RequestParam("ids") String[] ids){
        return UserService.deleteUser(Arrays.asList(ids)) ? R.ok() : R.fail();
    }
    @GetMapping("/list")
    @Operation(summary ="按当前页和页数大小返回User类的集合")
    @ApiImplicitParams({
        @ApiImplicitParam(name="current",value="当前页",dataTypeClass = Integer.class,paramType = "query"),
        @ApiImplicitParam(name="size",value="页数大小",dataTypeClass = Integer.class,paramType = "query")
    })
    public R list(@RequestParam("current") Integer current,@RequestParam("size") Integer size){
        try{
            Page<User> PojoPage = UserService.queryUserPage(current, size);
            Page<UserVo> VoPage = new Page<>();
            BeanUtils.copyProperties(PojoPage,VoPage);
            return R.ok(VoPage);
        }catch (Exception e){
            return R.fail();
        }
    }
    @PostMapping("/list")
    @Operation(summary ="按id返回User类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R listById(@RequestBody JSONObject obj){
        try{
            List<String> ids = obj.getList("ids", String.class, IgnoreNoneSerializable);
            List<User> PojoList = UserService.queryUserListById(ids);
            List<UserVo> VoList = PojoList.stream().map(pojo -> {
                UserVo vo = new UserVo();
                BeanUtils.copyProperties(pojo, vo);
                return vo;
            }).collect(Collectors.toList());
            return R.ok(VoList);
        }catch (Exception e){
            return R.fail();
        }
    }

}

