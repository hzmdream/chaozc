package com.czc.core.message.resp;

/** 
* @ClassName: RespBaseMessage 
* @Description: TODO( 消息基类（公众号-->普通用户）) 
* @author A18ccms a18ccms_gmail_com 
* @date 2016年8月20日 下午11:20:56 
*  
*/ 
public class RespBaseMessage {

	//接收方账号（收到的OpenID）
	private String ToUserName;
	//开发者微信号
	private String FromUserName;
	//消息创建时间（整型）
	private long CreateTime;
	//消息类型
	private String MsgType;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
