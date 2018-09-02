package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class TestFastJson {

	public static void main(String[] args) {

		JSONObject jsonObject = JSONObject.parseObject("{\"studentName\":\"lily\",\"studentAge\":12}");

//		System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
//				+ jsonObject.getInteger("studentAge"));

		Student student = new Student();
		student.setStudentAge(1);
		student.setStudentName("哈哈");

		Student student1 = new Student();
		student1.setStudentAge(2);
		student1.setStudentName("hee");

		Student student2 = new Student();
		student2.setStudentAge(3);
		student2.setStudentName("嘿嘿");

		List<Student> list = new ArrayList<>();
		list.add(student);
		list.add(student1);
		list.add(student2);
		
		

		// Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>()
		// {});
		// Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new
		// TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的
		String listJson = JSONObject.toJSONString(list);
//		System.out.println(listJson);

		List<Student> newList = new ArrayList<>();
		newList = JSON.parseObject(listJson, new TypeReference<List<Student>>() {
		});
		// JSONArray.parseObject(listJson, new TypeReference<ArrayList<Student>>() {});
		for (Student stu : newList) {
//			System.out.println(stu.getStudentName() + ":" + stu.getStudentAge());
		}
		
		
		Teacher teacher = new Teacher();
		teacher.setTeacherAge(1111);
		teacher.setTeacherName("dwadwada");
		teacher.setStudents(newList);

		String jsonTea = JSONObject.toJSONString(teacher);
		
//		System.out.println(jsonTea);
		Teacher tea = JSON.parseObject(jsonTea, new TypeReference<Teacher>() {});
		System.out.println(tea.toString());
		
	}

}
