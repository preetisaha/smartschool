package com.smartschool.domain;

public class Teacher {

		private int userId;
		private String teacherName;
		private String designation;
		
		public Teacher(int userId, String teacherName, String designation){
			this.userId = userId;
			this.teacherName = teacherName;
			this.designation = designation;
		}

		public int getUserId() {
			return userId;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public String getDesignation() {
			return designation;
		}
		
}
