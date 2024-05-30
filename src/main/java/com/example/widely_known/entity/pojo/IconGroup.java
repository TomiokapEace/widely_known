package com.example.widely_known.entity.pojo;

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
* @author  
* @since 2024-05-22
*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@TableName("icon_group")
@ApiModel(value = "IconGroup对象", description = "图片组")
public class IconGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("名字")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("图片路径")
    @TableField("icon_path")
    private String iconPath;

    @ApiModelProperty("关联id")
    @TableField("relevance_id")
    private String relevanceId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("图片组")
    @TableField("icon_group")
    private String iconGroup;
}
