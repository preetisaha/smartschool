package com.smartschool.domain;

public class Teacher {

		private int tid;
		private String teacherName;
		private String designation;
		
		public Teacher(int userId, String teacherName, String designation){
			this.tid = userId;
			this.teacherName = teacherName;
			this.designation = designation;
		}

		public int getUserId() {
			return tid;
		}

		public String getTeacherName() {
			return teacherName;
		}

		public String getDesignation() {
			return designation;
		}
		
}
