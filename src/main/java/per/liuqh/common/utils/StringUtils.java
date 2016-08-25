package per.liuqh.common.utils;

public class StringUtils {
	public static boolean isNotBlank(String str){
		if(null!=str&&!"".equals(str)){
			return true;
		}
		return false;
	}
	public static boolean isBlank(String str){
		return !isNotBlank(str);
	}
	public static void main(String[] args) {
		System.out.println(StringUtils.isBlank("abc"));
	}
}
