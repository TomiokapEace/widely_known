package com.example.widely_known.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* <p>
    * 家乡
    * </p>
*
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "WidelyDataVo对象", description = "家乡")
public class WidelyDataVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String icon;

    private String title;

    private String introduce;

    private String type;

    private String userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
