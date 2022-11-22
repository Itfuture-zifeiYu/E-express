package com.itfuture.e.util;



import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

/**自定义发送短信的工具类 （项目不用该类，使用sprinboot自动配置类）
 * @Description:
 * @Author 王小虎
 * @Version 1.0
 * @Date Created in 2022-01-03 13:05
 */
public class SMSUtil {

    // 短信应用 SDK AppID
    private static int appid = 1400617366; // SDK AppID 以1400开头
    // 短信应用 SDK AppKey
    private static  String appkey = "33b78b41201c1615ac8371dea7ffc418";
    // 需要发送短信的手机号码
//    String[] phoneNumbers = {"13279679928", "15147729248", "13038419621","18292312120"};
    // 短信模板 ID，需要在短信应用中申请
    private static  int templateId1 = 1264448; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
    private static  int templateId2 = 1265837; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
    // 签名
    private static  String smsSign = "Itfuture栈"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请

    public static boolean QCloudSmsSend(String phoneNumber,String code){
        try {
            String[] params = new String[1];
            params[0] =code;
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //sendWithParm:     传入国家码 电话号码 模板id 模板参数 签名 扩展码为空 返回参数为空
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId1, params, smsSign, "", "");
            if(result.result==0){
                return true;
            }else{
                System.out.println("短信发送失败，原因："+result.errMsg);
            }
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return false;
    }

    public static boolean loginSmsSend(String phoneNumber,String code){
        try {
            String[] params = new String[1];
            params[0] =code;
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //sendWithParm:     传入国家码 电话号码 模板id 模板参数 签名 扩展码为空 返回参数为空
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId2, params, smsSign, "", "");
            if(result.result==0){
                return true;
            }else{
                System.out.println("短信发送失败，原因："+result.errMsg);
            }
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return false;
    }
}
