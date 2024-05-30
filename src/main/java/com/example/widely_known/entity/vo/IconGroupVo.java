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
    * 图片组
    * </p>
*
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class IconGroupVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String iconPath;

    private String relevanceId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String iconGroup;
}
