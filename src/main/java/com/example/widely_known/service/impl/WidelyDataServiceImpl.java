package com.example.widely_known.service.impl;
import java.util.List;
import com.example.widely_known.entity.pojo.WidelyData;
import com.example.widely_known.entity.vo.WidelyDataVo;
import com.example.widely_known.entity.dto.WidelyDataDto;
import com.example.widely_known.mapper.WidelyDataMapper;
import com.example.widely_known.service.WidelyDataService;
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
    * 家乡 服务实现类
    * </p>
*
* @author  
* @since 2024-05-22
*/
@Service
public class WidelyDataServiceImpl extends ServiceImpl<WidelyDataMapper, WidelyData> implements WidelyDataService {
    private final QueryWrapper<WidelyData> queryWrapper = new QueryWrapper<>();

    public boolean updateWidelyDataById(WidelyData entity){
        return this.getBaseMapper().updateById(entity)==1;
    }

    public boolean insertWidelyData(WidelyData entity){
        return this.getBaseMapper().insert(entity)==1;
    }

    public boolean deleteWidelyData(List<String> ids){
        for (String id : ids) {
        if(this.getBaseMapper().deleteById(id)!=1)
            return false;
        }
        return true;
    }

    public List<WidelyData> queryWidelyDataListById(List<String> ids){
        queryWrapper.clear();
        for (int i = 0; i < ids.size(); i++) {
            queryWrapper.eq("id",ids.get(i));
        if (i!=ids.size()-1)
            queryWrapper.or();
        }
        List<WidelyData> selectList = this.getBaseMapper().selectList(queryWrapper);
        return selectList;
    }

    public Page<WidelyData> queryWidelyDataPage(Integer current,Integer size){
        queryWrapper.clear();
        return queryWidelyDataPage(current,size,queryWrapper);
    }

    public Page<WidelyData> queryWidelyDataPage(Integer current,Integer size,QueryWrapper<WidelyData> queryWrapper){
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListById(Integer value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListById(Integer current,Integer size,Integer value){
        queryWrapper.clear();
        queryWrapper.eq("id",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByTitle(String value){
        queryWrapper.clear();
        queryWrapper.eq("title",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByTitle(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("title",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByIntroduce(String value){
        queryWrapper.clear();
        queryWrapper.eq("introduce",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByIntroduce(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("introduce",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByType(String value){
        queryWrapper.clear();
        queryWrapper.eq("type",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByType(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("type",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByUserId(String value){
        queryWrapper.clear();
        queryWrapper.eq("userId",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByUserId(Integer current,Integer size,String value){
        queryWrapper.clear();
        queryWrapper.eq("userId",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByCreateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByCreateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("createTime",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
    public List<WidelyData> queryWidelyDataListByUpdateTime(LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectList(queryWrapper);
    }
    public Page<WidelyData> queryWidelyDataListByUpdateTime(Integer current,Integer size,LocalDateTime value){
        queryWrapper.clear();
        queryWrapper.eq("updateTime",value);
        return this.getBaseMapper().selectPage(new Page<WidelyData>(current,size),queryWrapper);
    }
}
