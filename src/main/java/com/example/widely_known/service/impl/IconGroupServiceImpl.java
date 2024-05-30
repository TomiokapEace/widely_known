package com.example.widely_known.service.impl;
import java.util.List;
import com.example.widely_known.entity.pojo.IconGroup;
import com.example.widely_known.entity.vo.IconGroupVo;
import com.example.widely_known.entity.dto.IconGroupDto;
import com.example.widely_known.mapper.IconGroupMapper;
import com.example.widely_known.service.IconGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
* <p>
    * 图片组 服务实现类
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Service
public class IconGroupServiceImpl extends ServiceImpl<IconGroupMapper, IconGroup> implements IconGroupService {
    private  QueryWrapper<IconGroup> queryWrapper = new QueryWrapper<>();

    public boolean updateIconGroupById(IconGroup entity){
        return this.getBaseMapper().updateById(entity)==1;
    }

    public boolean insertIconGroup(IconGroup entity){
        return this.getBaseMapper().insert(entity)==1;
    }

    public boolean deleteIconGroup(List<String> ids){
        for (String id : ids) {
        if(this.getBaseMapper().deleteById(id)!=1)
            return false;
        }
        return true;
    }

    public List<IconGroup> queryIconGroupListById(List<String> ids){
        queryWrapper.clear();
        for (int i = 0; i < ids.size(); i++) {
            queryWrapper.eq("id",ids.get(i));
        if (i!=ids.size()-1)
            queryWrapper.or();
        }
        List<IconGroup> selectList = this.getBaseMapper().selectList(queryWrapper);
        return selectList;
    }

    public Page<IconGroup> queryIconGroupPage(Integer current,Integer size){
        queryWrapper.clear();
        return queryIconGroupPage(current,size,queryWrapper);
    }

    public Page<IconGroup> queryIconGroupPage(Integer current,Integer size,QueryWrapper<IconGroup> queryWrapper){
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListById(String value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListById(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByName(String value){
        queryWrapper.clear();
        queryWrapper.eq("name",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListByName(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("name",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByIconPath(String value){
        queryWrapper.clear();
        queryWrapper.eq("iconPath",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListByIconPath(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("iconPath",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByRelevanceId(String value){
        QueryWrapper<IconGroup> wrapper = new QueryWrapper<>();
        wrapper.eq("relevance_id",value);
        return this.getBaseMapper().selectList(wrapper);
    }
    public Page<IconGroup> queryIconGroupListByRelevanceId(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("relevanceId",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByCreateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListByCreateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByUpdateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListByUpdateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
    public List<IconGroup> queryIconGroupListByIconGroup(String value){
        queryWrapper.clear();
        queryWrapper.eq("iconGroup",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<IconGroup> queryIconGroupListByIconGroup(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("iconGroup",value);
        return this.getBaseMapper().selectPage(new Page<IconGroup>(current,size),queryWrapper);
    }
}
