package com.nagginglong.controller;

import com.nagginglong.entity.Adress;
import com.nagginglong.entity.City;
import com.nagginglong.service.CityService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 14:31
 */

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/select.do")
    @ResponseBody
    public Json2View slectCity(Integer pid){

        if (pid == null) {
            pid = 0;
        }

        List<City> cities = cityService.selectCity(pid);


        return  new Json2View(1,"查询成功！",0,cities);
    }


    @RequestMapping("/button.do")
    @ResponseBody
    public Json2View insertCity(Integer getid1, Integer getid2, Integer backid1, Integer backid2, HttpSession session){

        Adress adress = new Adress(getid1, getid2, backid1, backid2);

        session.setAttribute(ConstantsQantity.ADRESS,adress);

        return  new Json2View(1,"存放成功！",0,null);
    }


    @RequestMapping("/selectName.do")
    @ResponseBody
    public Json2View selectName(HttpSession session){

        Adress adress = (Adress)session.getAttribute(ConstantsQantity.ADRESS);

        City city = cityService.selectName(adress.getGetid2());

        City city1 = cityService.selectName(adress.getBackid2());


        String[] strings = new String[]{city.getName(),city1.getName()};

        return new Json2View(1,"获取成功！",0,strings);
    }




}
