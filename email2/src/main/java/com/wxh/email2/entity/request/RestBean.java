package com.wxh.email2.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 15:01
 */
@Data
@AllArgsConstructor
@ApiModel(description = "响应实体封装类")
public class RestBean<T> {
    @ApiModelProperty("状态码")
    int code;
    @ApiModelProperty("状态码信息")
    String reason;
    @ApiModelProperty("返回数据实体")
    T data;
    public RestBean(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}
