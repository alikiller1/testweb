package per.liuqh.entity;

import com.google.gson.Gson;

public class StudentInfo {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public static void main(String[] args) {
		String jsonString="{'name':'liu','age':11}";
		StudentInfo s=new Gson().fromJson(jsonString, StudentInfo.class);
		System.out.println(s.getAge());
		double sum=100000;
		double month=0;
		double allGet=0;
		for(int i=0;i<12;i++){
			month=sum*0.11/12;
			sum=sum+month-8561;
			allGet=allGet+month;
		}
		System.out.println(allGet);
		System.out.println(sum);
		System.out.println(allGet-2700);
	}
}
