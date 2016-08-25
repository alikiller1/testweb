package person.liuqh.utils;

import per.liuqh.common.utils.HttpRequest;

public class TestHttpRequest {
	
	public static void f2(){

		String url="http://mdev.paicaifu.com/lookActivity/v1.2";
		String params="activityId=160324144010000006&channalId=160411160410000020&channalType=2";
		HttpRequest.sendPost(url, params);
	
	}
	public static void f4(){
		String url="http://mdev.paicaifu.com/sign/shake/v1.0";
		String params="activityId=160324144010000006&channalId=160411160410000020&channalType=2";
		HttpRequest.sendPost(url, params);
	
	}
	public static void f3(){
		String url="http://mdev.paicaifu.com/sign/sendYuanbao/v1.0";
		String params="activityId=160324144010000006&channalId=160411160410000020&channalType=2";
		HttpRequest.sendPost(url, params);
	
	}
	
	public static void f5(){
		String url="http://mdev.paicaifu.com/login/v1.0 ";
		String params="activityId=160324144010000006&channalId=160411160410000020&channalType=2&loginName=18670708641&loginPwd=test123";
		HttpRequest.sendPost(url, params);
	
	}
	public static void main(String[] args) {
		f3();
	}
}
