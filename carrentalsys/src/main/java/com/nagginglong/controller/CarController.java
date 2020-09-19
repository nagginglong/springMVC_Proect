package com.nagginglong.controller;

import com.nagginglong.entity.Adress;
import com.nagginglong.entity.Car;
import com.nagginglong.service.CarService;
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
 * @Date:2020/9/17 17:25
 */

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/showCar.do")
    @ResponseBody
    public Json2View showCar(HttpSession session,Integer page,Integer limit){

        Adress adress = (Adress)session.getAttribute(ConstantsQantity.ADRESS);

        Integer getid2 = adress.getGetid2();

        Json2View json2View = carService.selectCar(getid2, page, limit);


        return json2View;

    }

    @RequestMapping("/findCar.do")
    @ResponseBody
    public Json2View findCar(Integer id){
        Car car = carService.selectOneCar(id);

        return new Json2View(1,"查询车辆成功！",0,car);

    }


}
