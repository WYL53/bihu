package com.wyl.bihu.controllers;

import com.wyl.bihu.Model.BaseUserInfo;
import com.wyl.bihu.Model.ResponseMsg;
import com.wyl.bihu.Model.ResponseStatus;
import com.wyl.bihu.Model.UserInfo;
import com.wyl.bihu.services.IUserService;
import com.wyl.bihu.services.impl.UserServiceImp;
import com.wyl.bihu.util.StringUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/23.
 */
@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping({"/","index"})
    public String index(ModelMap map){
//        System.out.println("index");
//        UserInfo u = new UserInfo("abc","testName");
//        map.addAttribute("userName",u);
        map.addAttribute("userName", "WYL");
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseMsg register(BaseUserInfo baseUserInfo){
        UserInfo userInfo = new UserInfo(baseUserInfo);
        String uid = StringUtil.generateUUID(10);
        userInfo.setUuid(uid);
        String salt = StringUtil.generateUUID(10);
        userInfo.setSalt(salt);
        userInfo.setSaltPassword( generatePassword(baseUserInfo.getPassword(),salt));
        System.out.println(userInfo);
        if (userService.addUser(userInfo) > 0) {
            return new ResponseMsg(ResponseStatus.OK);
        }
        return new ResponseMsg(ResponseStatus.FAIL);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseMsg login(@RequestParam("email") String email,
                             @RequestParam("password")String password){
        try {
            UserInfo userInfo = userService.findByEmail(email);
            String saltPassword = userInfo.getSaltPassword();
            if(saltPassword.compareTo(generatePassword(password,userInfo.getSalt())) == 0){
                return new ResponseMsg(ResponseStatus.OK);
            }
        }catch (Exception ex){
            logger.info("login:"+ex.toString());
        }

        return new ResponseMsg(ResponseStatus.FAIL);
    }

    private String generatePassword(String rawPasswd,String salt){
        return salt+rawPasswd;
    }
}
