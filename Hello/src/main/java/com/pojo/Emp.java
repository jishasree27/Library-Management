package com.pojo;
import javax.persistence.*;
@Entity
@Table(name="student")
public class Emp {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;

		@Column(name="name")
		private String name;

		@Column(name="dept")
		private String dept;

		@Column(name="clg")
		private String clg;
		
		@Column(name="phone")
		private String phone;

		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getClg() {
			return clg;
		}
		public void setClg(String clg) {
			this.clg = clg;
		}

		@Override
		public String toString() {
			return "Emp{" +
					"name='" + name + '\'' +
					", dept='" + dept + '\'' +
					", clg='" + clg + '\'' +
					", phone='" + phone + '\'' +
					'}';
		}
	}


