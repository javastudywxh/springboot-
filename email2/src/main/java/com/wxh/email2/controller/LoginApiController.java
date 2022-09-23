package com.wxh.email2.controller;

import com.wxh.email2.Service.UserService;
import com.wxh.email2.Service.VerifyService;
import com.wxh.email2.entity.request.RestBean;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 15:00
 */
@CrossOrigin
@Api(tags = "账户的验证接口",description = "用户的登录登出注册获取验证码操作。")
@RestController
@RequestMapping("/api/auth")
public class LoginApiController {
    @Resource
    VerifyService verifyService;
    @Resource
    UserService userService;
    @ApiResponses({
            @ApiResponse(code = 200,message = "邮件发送成功"),
            @ApiResponse(code = 500,message = "邮件发送失败")
    })
    @ApiOperation("请求邮件验证码")
    @GetMapping("/verify-code")
    public RestBean verifyCode(@ApiParam("邮箱地址") @RequestParam("email") String email){
        try {
            verifyService.sendVerifyCode(email);
            return new RestBean(200,"邮件发送成功");
        }catch (Exception e){
            return new RestBean(500,"邮件发送失败");
        }
    }
    @ApiOperation("用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public RestBean register(@ApiParam("用户名") @RequestParam String username,
                             @ApiParam("用户密码") @RequestParam String password,
                             @ApiParam("邮箱地址") @RequestParam String email,
                             @ApiParam("验证码") @RequestParam String verify){
        if (verifyService.doVerify(email,verify)){
            userService.insertUser(password,username,email);
            return new RestBean(200,"注册成功");
        }else {
            return new RestBean(403,"注册失败，验证码填写错误");
        }
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "邮件发送成功"),
            @ApiResponse(code = 500,message = "邮件发送失败，或邮箱不正确")
    })
    @ApiOperation("忘记密码的请求邮件验证码")
    @GetMapping("/verifyNotNullCode")
    public RestBean verifyNotNullCode(@ApiParam("邮箱地址") @RequestParam("email") String email,
                                      @ApiParam("用户名") @RequestParam("username") String username){
        try {
            verifyService.sendNotNullVerifyCode(email,username);
            return new RestBean(200,"邮件发送成功");
        }catch (Exception e){
            return new RestBean(500,"邮件发送失败，或邮箱不正确");
        }
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "修改成功"),
            @ApiResponse(code = 403,message = "修改失败，验证码填写错误")
    })
    @ApiOperation("用户注册")
    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public RestBean forgot(@ApiParam("用户名") @RequestParam String username,
                             @ApiParam("用户密码") @RequestParam String password,
                             @ApiParam("邮箱地址") @RequestParam String email,
                             @ApiParam("验证码") @RequestParam String verify){
        if (verifyService.doVerify(email,verify)){
            userService.updateUser(username,password);
            return new RestBean(200,"修改成功");
        }else {
            return new RestBean(403,"修改失败，验证码填写错误");
        }
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "登录成功"),
    })
    @ApiOperation("登录成功")
    @PostMapping("/login-success")
    public RestBean loginSuccess(){
        return new RestBean(200,"登录成功");
    }
    @ApiResponses({
            @ApiResponse(code = 403,message = "登陆失败，用户名或密码错误")
    })
    @ApiOperation("登陆失败，用户名或密码错误")
    @PostMapping("/login-failure")
    public RestBean loginFailure(){
        return new RestBean(403,"登陆失败，用户名或密码错误");
    }
    @ApiResponses({
            @ApiResponse(code = 200,message = "用户退出成功"),
    })
    @ApiOperation("用户退出成功")
    @GetMapping("/logout-success")
    public RestBean logoutSuccess(){
        return new RestBean(200,"退出成功");
    }
    @ApiIgnore
    @GetMapping("/access-deny")
    public RestBean accessDeny(){
        return new RestBean(401,"未验证，请先登录");
    }
}
