package com.wang.enrekaclient2.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestControl {

    /**
     * 假如这个客户端要提供一个getUser的方法
     * 错误异常处理方法:
     * @return
     */
    @GetMapping(value = "/getUser")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "getErrorMap")
    public Map<String,Object> getUser(@RequestParam Integer id){
        Map<String,Object> data = new HashMap<>();
        data.put("id",id);
        data.put("userName","admin");
        data.put("from","provider-B");
        if(1==1){
            throw  new NumberFormatException();
        }
        return data;
    }

    /**
     * 异常错误处理方法
     * 需要注意一点，该方法需要原方法参数个数和类型保持一致
     *
     * @param id
     * @return
     */
    public  Map<String,Object> getErrorMap(Integer id){
        Map<String,Object> map=new HashMap<>();
        map.put("msg","错误信息");
        map.put("status","error");
        return  map;
    }



}
