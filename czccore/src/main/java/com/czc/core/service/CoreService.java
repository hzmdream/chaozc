package com.czc.core.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czc.core.message.resp.RespTextMessage;
import com.czc.core.util.MessageUtil;

public class CoreService {
	private static Logger log = LoggerFactory.getLogger(CoreService.class);
	private static Map<String, Object> globalOpenIdMap = new HashMap<String, Object>();
	private static Map<String, Object> globalCreateTimeMap = new HashMap<String, Object>();
	/** 
	* @Title: processRequest 
	* @Description: TODO(处理微信发来的请求) 
	* @param request
	* @return String    解析微信发来的xml请求为String类型
	* @throws 
	*/
	public static String processRequest(HttpServletRequest request){
		//xml格式的消息数据
		String respXml = null;
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			if (requestMap.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				respXml = event(requestMap);
			}else {
				respXml = message(requestMap);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respXml;
	}
	
	private static String message(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String event(Map<String, String> requestMap){
		String respXml = null;
		//事件类型
		String eventType = requestMap.get("Event");
		//事件类型：订阅
		if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			RespTextMessage respTextMessage = new RespTextMessage();
			//发送方账号
			respTextMessage.setFromUserName(requestMap.get("ToUserName"));
			//开发者微信公众号
			respTextMessage.setToUserName(requestMap.get("FromUserName"));
			//创建时间
			respTextMessage.setCreateTime(new Date().getTime()/1000);
			//消息类型
			respTextMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			//消息内容
			respTextMessage.setContent("享受生活，从心开始");
			//保存相关用户信息
//			saveWechatUser(requestMap.get("FromUserName"));
			//将消息对象转换成xml
			respXml = MessageUtil.messageToXml(respTextMessage);
		}
		return respXml;
	}
	
//	private static void saveWechatUser(String openId){
//		if (!globalOpenIdMap.containsKey(openId)) {
//			
//		}
//	}
}
