package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService_consumer;
import com.netflix.discovery.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RequestMapping("/users")
@Controller
public class UsersController_consumer {

    @Autowired
    private UsersService_consumer usersService_consumer;

    //管理员后台登录
    @RequestMapping("/back/adminLogin")
    public String adminLogin(Users users, Model model) {
        //解密
        //String password = DigestUtils.md5DigestAsHex(users.getPassWord().getBytes());
        // users.setPassWord(password);
        if (usersService_consumer.adminLogin(users) == null) {
            model.addAttribute("errorMess", "用户名或密码错误");
            return "login";
        } else {
            return "frame";
        }
    }

    //查询用户
    @RequestMapping("/back/findUsers/{userName}")
    @ResponseBody
    public Map<String, Object> findUsers(@PathVariable("userName") String userName) {
        List<Users> list = usersService_consumer.findUsers(userName);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    //删除用户
    @RequestMapping("/back/delUser/{id}")
    @ResponseBody
    public int delUser(@PathVariable("id") Integer id) {
        return usersService_consumer.delUser(id);
    }

//根据id查询
    @RequestMapping("/back/findById/{id}")
    @ResponseBody
    public Users findById(@PathVariable("id") Integer id) {
        return  usersService_consumer.findById(id);
    }

    //修改用户
    @RequestMapping("/back/updateUser")
    @ResponseBody
    public int updateUser(Users user, MultipartFile file, HttpServletRequest request){
        String path = "D:\\IdeaProjects\\GuoMei\\consumer-back\\src\\main\\resources\\static\\fileupload";
        if(!file.isEmpty()) {    //传过来的文件不为空
            String uuid = UUID.randomUUID().toString();   //保证每个的文件名不重复
            //源文件名
            String originalFilename=uuid+file.getOriginalFilename();
            //文件的真实类型
            String contentType = file.getContentType();
                File fi=new File(path,originalFilename);
            try {
                //写入指定盘符
                file.transferTo(fi);
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setHeadImg(originalFilename);
        }
        int count=0;
        if(user.getId()!=null){
            count=usersService_consumer.updateUser(user);
        }
        return count;
    }
}