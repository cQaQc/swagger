package com.kk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel("用户实体类")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty("用户id")
    private int id;
    @ApiModelProperty("用户姓名")
    private String name;


    @ApiModelProperty("生日")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birth;
}
