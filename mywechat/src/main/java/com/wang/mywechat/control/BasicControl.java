package com.wang.mywechat.control;

import com.wang.mywechat.service.BasicService;
import com.wang.mywechat.util.MessageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//无法直接在里面实现业务逻辑，。还是需要requestMappring
@RestController
@RequestMapping("/wechat")
public class BasicControl {

    @Resource
    private BasicService basicService;

    /**
     * 微信服务器验证，接收到如下参数，将参数加密，并与微信传递过来的加密参数比较，如果一致
     * 则返回echostr字符串，代表核验成功。
     * @param req
     * @return
     */
    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    public String Connection(HttpServletRequest req) {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce"); //随机数
        String echostr = req.getParameter("echostr");//随机字符串
        return basicService.verify(signature, timestamp, nonce, echostr);
    }

    /**
     *
     * 接收用户的扫码推事件或者被动回复相关消息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/connection", method = RequestMethod.POST)
   public void Connection2(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Map<String, String> paramMap = MessageUtil.parseXml(request);
            String result = MessageUtil.buildXml(paramMap);
            if("".equals(result)){
                result="未正确响应信息";
            }
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(result.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
   }

    /**
     * 获取accessToken在很多验证接口均能使用到
     * @return
     */
     @RequestMapping(value = "/getAccessToken",method = RequestMethod.GET)
    public String getAccessToken(){
        return  basicService.getAccessToken();
    }

    /**
     * 创建系统页面主菜单:
     * @return
     */
    @RequestMapping(value = "/createMenu",method = RequestMethod.GET)
    public String createMenu(){
        return basicService.createMenu();
    }
}
