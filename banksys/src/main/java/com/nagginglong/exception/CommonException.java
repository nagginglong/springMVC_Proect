package com.nagginglong.exception;

import com.nagginglong.utils.Json2View;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * description: 验证器，判断用户输入的内容是否按照格式来输入的。
 * 需要添加ValidationMessages配置文件来进行
 *
 * @author:像大山一样
 * @Date:2020/9/11 11:27
 */
@ControllerAdvice//控制器的增强
@ResponseBody//判断传入的参数后要进行JSON的返回
public class CommonException {

    //修饰方法，表示这个方法是处理异常的类
    @ExceptionHandler(ConstraintViolationException.class)
    public Json2View constraintViolationException(ConstraintViolationException e){
        //验证不通过的信息
        Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();

        String s = null;

        if (iterator.hasNext()) {

             s = iterator.next().getMessage();

            System.out.println("不通过的原因是：" + s);

        }

        return new Json2View(0,s);

    }



    //除以意料之外的异常

    @ExceptionHandler
    public Json2View commonException (Exception e){
        return new Json2View(0, e.getMessage());
    }

}
