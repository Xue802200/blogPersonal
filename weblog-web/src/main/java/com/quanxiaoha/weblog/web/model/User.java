package com.quanxiaoha.weblog.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class User {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "性别不能为空")
    private Integer sex;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18,message = "年龄最低不能少于18岁")
    @Max(value = 100,message = "年龄最大不能大于100岁")
    private Integer age;

    //创建时间
    private LocalDateTime createTime;

    //更新时间
    private LocalDate updateTime;

    //当前时间
    private LocalTime time;
}
