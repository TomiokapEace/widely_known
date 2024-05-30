package com.example.widely_known.controller;
import com.example.widely_known.entity.pojo.IconGroup;
import com.example.widely_known.service.IconGroupService;
import com.example.widely_known.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.lang.reflect.Field;
import com.example.widely_known.entity.pojo.WidelyData;
import com.example.widely_known.entity.vo.WidelyDataVo;
import com.example.widely_known.entity.dto.WidelyDataDto;
import com.example.widely_known.service.WidelyDataService;
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
    * WidelyData 前端控制器
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Api(tags="家乡相关接口")
@RestController
@RequestMapping("/api/widely_known/widelyData")
public class WidelyDataController {
    @Autowired
    private WidelyDataService WidelyDataService;
    @Resource
    private IconGroupService iconGroupService;
    private final String permission_prefix="widely_known:widelyData:";

    @PostMapping("/select")
    @Operation(summary ="条件查询WidelyData类")
    @ApiImplicitParams(
    {
    @ApiImplicitParam(name="WidelyData",value="WidelyData实体类",dataTypeClass = WidelyData.class,paramType = "body"),
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
        QueryWrapper<WidelyData> wrapper = new QueryWrapper<>();
        Field[] fields = WidelyData.class.getDeclaredFields();
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
        Page<WidelyData> WidelyDataPage =null;
        try {
            WidelyDataPage = WidelyDataService.queryWidelyDataPage(current, size, wrapper);
        }catch (Exception e){
            WidelyDataPage = WidelyDataService.queryWidelyDataPage(current, size);
            return R.ok(WidelyDataPage);
        }
        List<WidelyDataVo> list = new ArrayList<>();
        Page<WidelyDataVo> VoPage =new Page<>();
        for (WidelyData record : WidelyDataPage.getRecords()) {
            String iconPath = null;
            try {
                iconPath = iconGroupService.queryIconGroupListByRelevanceId(record.getId().toString())
                        .get(0).getIconPath();

            } catch (Exception e) {
                iconPath="";

            }
            WidelyDataVo vo = new WidelyDataVo();
            BeanUtils.copyProperties(record,vo);
            vo.setIcon(iconPath);
            list.add(vo);
        }
        BeanUtils.copyProperties(WidelyDataPage,VoPage);
        VoPage.setRecords(list);

        return R.ok(VoPage);
    }
    @PostMapping("/add")
    @Operation(summary ="添加WidelyData类")
    @ApiImplicitParam(name="form",value="WidelyData实体类",dataTypeClass = WidelyData.class,paramType = "body")
    public R Add(@Valid @RequestBody WidelyDataDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
            return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        WidelyData pojoEntity = new WidelyData();
        BeanUtils.copyProperties(entity,pojoEntity);
        return WidelyDataService.insertWidelyData(pojoEntity)?R.ok():R.fail();
    }

    @PostMapping("/update")
    @Operation(summary ="按id修改WidelyData类")
    @ApiImplicitParam(name="form",value="WidelyData实体类",dataTypeClass = WidelyData.class,paramType = "body")
    public R Update(@Valid @RequestBody WidelyDataDto entity, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            for (ObjectError allError : bindingResult.getAllErrors()) {
                return R.fail(HttpStatus.BAD_REQUEST,allError.getDefaultMessage());
            }
        }
        WidelyData pojoEntity = new WidelyData();
        BeanUtils.copyProperties(entity,pojoEntity);
        return WidelyDataService.updateWidelyDataById(pojoEntity)?R.ok():R.fail();
    }
    @GetMapping("/deleted")
    @Operation(summary ="按id删除WidelyData类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R deleted(@RequestParam("ids") String[] ids){
        return WidelyDataService.deleteWidelyData(Arrays.asList(ids)) ? R.ok() : R.fail();
    }
    @GetMapping("/list")
    @Operation(summary ="按当前页和页数大小返回WidelyData类的集合")
    @ApiImplicitParams({
        @ApiImplicitParam(name="current",value="当前页",dataTypeClass = Integer.class,paramType = "query"),
        @ApiImplicitParam(name="size",value="页数大小",dataTypeClass = Integer.class,paramType = "query")
    })
    public R list(@RequestParam("current") Integer current,@RequestParam("size") Integer size){
        try{
            Page<WidelyData> PojoPage = WidelyDataService.queryWidelyDataPage(current, size);
            Page<WidelyDataVo> VoPage = new Page<>();
            BeanUtils.copyProperties(PojoPage,VoPage);
            return R.ok(VoPage);
        }catch (Exception e){
            return R.fail();
        }
    }
    @PostMapping("/list")
    @Operation(summary ="按id返回WidelyData类")
    @ApiImplicitParam(name="ids",value="id数组",dataTypeClass = String[].class,paramType = "query")
    public R listById(@RequestBody JSONObject obj){
        try{
            List<String> ids = obj.getList("ids", String.class, IgnoreNoneSerializable);
            List<WidelyData> PojoList = WidelyDataService.queryWidelyDataListById(ids);
            List<WidelyDataVo> VoList = PojoList.stream().map(pojo -> {
                WidelyDataVo vo = new WidelyDataVo();
                BeanUtils.copyProperties(pojo, vo);
                return vo;
            }).collect(Collectors.toList());
            return R.ok(VoList);
        }catch (Exception e){
            return R.fail();
        }
    }

}

