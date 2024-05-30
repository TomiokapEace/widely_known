package com.example.widely_known.service;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.example.widely_known.entity.pojo.WidelyData;
import com.example.widely_known.entity.vo.WidelyDataVo;
import com.example.widely_known.entity.dto.WidelyDataDto;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 家乡 服务类
 * </p>
 *
 * @author  
 * @since 2024-05-22
 */
public interface WidelyDataService extends IService<WidelyData> {

    boolean updateWidelyDataById(WidelyData entity);

    boolean insertWidelyData(WidelyData entity);

    boolean deleteWidelyData(List<String> ids);

    List<WidelyData> queryWidelyDataListById(List<String> ids);

    Page<WidelyData> queryWidelyDataPage(Integer current,Integer size);

    Page<WidelyData> queryWidelyDataPage(Integer current,Integer size,QueryWrapper<WidelyData> queryWrapper);

    List<WidelyData> queryWidelyDataListById(Integer value);

    Page<WidelyData> queryWidelyDataListById(Integer current,Integer size,Integer value);

    List<WidelyData> queryWidelyDataListByTitle(String value);

    Page<WidelyData> queryWidelyDataListByTitle(Integer current,Integer size,String value);

    List<WidelyData> queryWidelyDataListByIntroduce(String value);

    Page<WidelyData> queryWidelyDataListByIntroduce(Integer current,Integer size,String value);

    List<WidelyData> queryWidelyDataListByType(String value);

    Page<WidelyData> queryWidelyDataListByType(Integer current,Integer size,String value);

    List<WidelyData> queryWidelyDataListByUserId(String value);

    Page<WidelyData> queryWidelyDataListByUserId(Integer current,Integer size,String value);

    List<WidelyData> queryWidelyDataListByCreateTime(LocalDateTime value);

    Page<WidelyData> queryWidelyDataListByCreateTime(Integer current,Integer size,LocalDateTime value);

    List<WidelyData> queryWidelyDataListByUpdateTime(LocalDateTime value);

    Page<WidelyData> queryWidelyDataListByUpdateTime(Integer current,Integer size,LocalDateTime value);

}
