package com.guomei.controller;

import com.guomei.pojo.Grade;
import com.guomei.pojo.Users;
import com.guomei.service.UsersService_consumer;
import com.netflix.discovery.util.StringUtil;
import com.sun.java.browser.plugin2.liveconnect.v1.Result;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jnlp.IntegrationService;
import javax.naming.spi.DirStateFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

@RequestMapping("/users")
@Controller
public class UsersController_consumer {

    @Autowired
    private UsersService_consumer usersService_consumer;

    //管理员后台登录
    @RequestMapping("/back/adminLogin")
    public String adminLogin(Users users, Model model, HttpSession session) {
        //解密
        //String password = DigestUtils.md5DigestAsHex(users.getPassWord().getBytes());
        // users.setPassWord(password);
        if (usersService_consumer.adminLogin(users) == null) {
            model.addAttribute("errorMess", "用户名或密码错误");
            return "login";
        } else {
            session.setAttribute("user", users);
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
    public int updateUser(@RequestParam  Map<String, String> map){
        Users user = new Users();
        user.setId(Integer.valueOf(map.get("id")));
        user.setUserName(map.get("userName"));
       user.setSex(Integer.valueOf(map.get("sex")));
       user.setBirthday(Date.valueOf(map.get("birthday")));
       user.setPhone(map.get("phone"));
       user.setEmail(map.get("email"));
       user.setTime(Date.valueOf(map.get("time")));
       user.setAddress(map.get("address"));
       user.setHeadImg(map.get("headImg"));
        return usersService_consumer.updateUser(user);
    }

    //上传用户头像
    @RequestMapping("/back/upload/img")
    @ResponseBody
    public Map<String, Object>  upload(MultipartFile file, HttpServletRequest request) throws IOException{

        // "D:/Nignx4FileServer/nginx-1.14.2/html/images"
        //"http://127.0.0.1:88/upload/"+图片名

            //图片存入路径
            String path = "D:/Nignx4FileServer/nginx-1.14.2/html/images";
        Map<String, Object> res = new HashMap<>();
            if(!file.isEmpty()) {    //传过来的文件不为空
                String uuid = UUID.randomUUID().toString();   //保证每个的文件名不重复
                //源文件名
                String originalFilename=uuid+file.getOriginalFilename();
                //文件的真实类型
                String contentType = file.getContentType();
                File f=new File(path,originalFilename);
                if(!f.getParentFile().exists()){
                    f.getParentFile().mkdir();
                }
                    //写入指定盘符
                file.transferTo(f);
                //返回图片url
                res.put("url", "http://127.0.0.1:88/upload/"+originalFilename);
            }
        return res;
    }

    //查询会员
    @RequestMapping("/back/findVip/{userName}/{gradeName}")
    @ResponseBody
    public Map<String, Object> findVip(@PathVariable("userName") String userName,@PathVariable("gradeName") String gradeName){
        Map hm=new HashMap();
        hm.put("userName",userName);
        hm.put("gradeName",gradeName);
        List<Map> list = usersService_consumer.findVip(hm);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", list.size());
        map.put("data", list);
        return  map;
    }

//显示所有会员等级
    @RequestMapping("/back/allGrade")
    @ResponseBody
     public  List<Grade> allGrade(){
        return  usersService_consumer.allGrade();
    }
}