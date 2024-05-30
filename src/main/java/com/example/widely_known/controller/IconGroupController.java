package com.example.widely_known.controller;
import com.example.widely_known.service.UserService;
import com.example.widely_known.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.fastjson2.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.lang.reflect.Field;
import com.example.widely_known.entity.pojo.IconGroup;
import com.example.widely_known.entity.vo.IconGroupVo;
import com.example.widely_known.entity.dto.IconGroupDto;
import com.example.widely_known.service.IconGroupService;
import com.example.widely_known.utils.HttpStatus;
import com.example.widely_known.entity.vo.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import static com.alibaba.fastjson2.JSONReader.Feature.IgnoreNoneSerializable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
* <p>
    * IconGroup 前端控制器
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Api(tags="图片组相关接口")
@RestController
@RequestMapping("/api/widely_known/iconGroup")
public class IconGroupController {
    @Autowired
    private IconGroupService IconGroupService;
    @Resource
    private UserService userService;
    private final String permission_prefix="widely_known:iconGroup:";
    @Value("${upload_path}")
    private String uploadPath;

    @PostMapping("/upload")
    public R upload(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = params.getFile("file");
        File savePath = new File(uploadPath);

        byte[] bytes;
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            return R.fail();
        }//文件上传的地址

        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        //用于查看路径是否正确
        OutputStream os = Files.newOutputStream(Paths.get(uploadPath+"/"+file.getOriginalFilename()));
        os.write(bytes, 0, bytes.length);
        os.flush();
        os.close();
        String id = params.getHeader("id");
        String user_id = params.getHeader("user_id");
//        boolean update = IconGroupService.update(new UpdateWrapper<IconGroup>().eq("id", id).set("icon_path", "/static/" + file.getOriginalFilename()));
        IconGroup iconGroup = new IconGroup();
        iconGroup.setIconPath("/static/" + file.getOriginalFilename());
        iconGroup.setRelevanceId(id);
        iconGroup.setName(userService.queryUserListById(user_id).get(0).getName());
        return IconGroupService.save(iconGroup)?R.ok():R.fail();
    }
    @PostMapping("/select")
    @Operation(summary ="条件查询IconGroup类")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name="IconGroup",value="IconGroup实体类",dataTypeClass = IconGroup.class,paramType = "body"),
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
        QueryWrapper<IconGroup> wrapper = new QueryWrapper<>();
        Field[] fields = IconGroup.class.getDeclaredFields();
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
        Page<IconGroup> IconGroupPage =null;
        try {
            IconGroupPage = IconGroupService.queryIconGroupPage(current, size, wrapper);
        }catch (Exception e){
            IconGroupPage = IconGroupService.queryIconGroupPage(current, size);
            return R.ok(IconGroupPage);
        }
        return R.ok(IconGroupPage);
    }
    @PostMapping("/add")
    @Operation(summary ="添加IconGroup类")
    @ApiImplicitParam(name="form",value="IconGroup实体类",dataTypeClass = IconGroup.class,paramType = "body")
    public R Add(@Valid @RequestBody IconGroupDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
            return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        IconGroup pojoEntity = new IconGroup();
        BeanUtils.copyProperties(entity,pojoEntity);
        return IconGroupService.insertIconGroup(pojoEntity)?R.ok():R.fail();
    }

    @PostMapping("/update")
    @Operation(summary ="按id修改IconGroup类")
    @ApiImplicitParam(name="form",value="IconGroup实体类",dataTypeClass = IconGroup.class,paramType = "body")
    public R Update(@Valid @RequestBody IconGroupDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
                return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        IconGroup pojoEntity = new IconGroup();
        BeanUtils.copyProperties(entity,pojoEntity);
        return IconGroupService.updateIconGroupById(pojoEntity)?R.ok():R.fail();
    }
    @GetMapping("/deleted")
    @Operation(summary ="按id删除IconGroup类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R deleted(@RequestParam("ids") String[] ids){
        return IconGroupService.deleteIconGroup(Arrays.asList(ids)) ? R.ok() : R.fail();
    }
    @GetMapping("/list")
    @Operation(summary ="按当前页和页数大小返回IconGroup类的集合")
    @ApiImplicitParams({
        @ApiImplicitParam(name="current",value="当前页",dataTypeClass = Integer.class,paramType = "query"),
        @ApiImplicitParam(name="size",value="页数大小",dataTypeClass = Integer.class,paramType = "query")
    })
    public R list(@RequestParam("current") Integer current,@RequestParam("size") Integer size){
        try{
            Page<IconGroup> PojoPage = IconGroupService.queryIconGroupPage(current, size);
            Page<IconGroupVo> VoPage = new Page<>();
            BeanUtils.copyProperties(PojoPage,VoPage);
            return R.ok(VoPage);
        }catch (Exception e){
            return R.fail();
        }
    }
    @PostMapping("/list")
    @Operation(summary ="按id返回IconGroup类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R listById(@RequestBody JSONObject obj){
        try{
            List<String> ids = obj.getList("ids", String.class, IgnoreNoneSerializable);
            List<IconGroup> PojoList = IconGroupService.queryIconGroupListById(ids);
            List<IconGroupVo> VoList = PojoList.stream().map(pojo -> {
                IconGroupVo vo = new IconGroupVo();
                BeanUtils.copyProperties(pojo, vo);
                return vo;
            }).collect(Collectors.toList());
            return R.ok(VoList);
        }catch (Exception e){
            return R.fail();
        }
    }

}

