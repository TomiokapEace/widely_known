package com.example.widely_known.service;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.example.widely_known.entity.pojo.IconGroup;
import com.example.widely_known.entity.vo.IconGroupVo;
import com.example.widely_known.entity.dto.IconGroupDto;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 * 图片组 服务类
 * </p>
 *
 * @author  
 * @since 2024-05-22
 */
public interface IconGroupService extends IService<IconGroup> {

    boolean updateIconGroupById(IconGroup entity);

    boolean insertIconGroup(IconGroup entity);

    boolean deleteIconGroup(List<String> ids);

    List<IconGroup> queryIconGroupListById(List<String> ids);

    Page<IconGroup> queryIconGroupPage(Integer current,Integer size);

    Page<IconGroup> queryIconGroupPage(Integer current,Integer size,QueryWrapper<IconGroup> queryWrapper);

    List<IconGroup> queryIconGroupListById(String value);

    Page<IconGroup> queryIconGroupListById(Integer current,Integer size,String value);

    List<IconGroup> queryIconGroupListByName(String value);

    Page<IconGroup> queryIconGroupListByName(Integer current,Integer size,String value);

    List<IconGroup> queryIconGroupListByIconPath(String value);

    Page<IconGroup> queryIconGroupListByIconPath(Integer current,Integer size,String value);

    List<IconGroup> queryIconGroupListByRelevanceId(String value);

    Page<IconGroup> queryIconGroupListByRelevanceId(Integer current,Integer size,String value);

    List<IconGroup> queryIconGroupListByCreateTime(LocalDateTime value);

    Page<IconGroup> queryIconGroupListByCreateTime(Integer current,Integer size,LocalDateTime value);

    List<IconGroup> queryIconGroupListByUpdateTime(LocalDateTime value);

    Page<IconGroup> queryIconGroupListByUpdateTime(Integer current,Integer size,LocalDateTime value);

    List<IconGroup> queryIconGroupListByIconGroup(String value);

    Page<IconGroup> queryIconGroupListByIconGroup(Integer current,Integer size,String value);

}
