package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/12 9:03
 */

@Controller
public class UpPortaritController {
    @Autowired
    private UserService userService;

    @RequestMapping("/upportarit.do")
    @ResponseBody
    public Json2 upPortarit(@RequestParam("file") MultipartFile file, HttpSession session){

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        if (user == null) {
            return new Json2(0,"账号未登录！",0,null);
        }
        //0.把文件写到本地磁盘里面，刚好对应咱们的虚拟路径  c:/upload
        //1.上传文件目录
        String s = "I:/QFEDU/项目/banksys/img";

        //2.获取上传文件的名字
        String fileName = file.getOriginalFilename();

        //3.判断上传文件的目录是否存在
        File file1 = new File(s);

        if (!file1.exists()) {

            //不存在就创建一个
            file1.mkdir();
        }

        //4.把上传的文件保存成一个对象
        //s表示需要上传到的路径，fileName表示上传的文件名

        File file2 = new File(s,fileName);

        try {

            //将上传的文件保存到对象中
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }

        //将文件传入到数据库中
        userService.upLoad(user.getUid(),"/img/" + fileName);


        return new Json2(1,"上传成功！",0,null);

    }
}
