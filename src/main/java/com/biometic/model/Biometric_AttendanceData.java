package com.biometic.model;




import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "pk_attendance_5id"), name = "biometric_attendancedata")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Biometric_AttendanceData  implements Serializable {

	
	
		//@NotEmpty
	// //@Temporal(TemporalType.TIME)
		@Column(nullable = false, name = "id")
		@JsonProperty("id")
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "status")
		@JsonProperty("status")
		private String status;
		
		
		@Column(name = "sequenceno")
		@JsonProperty("sequenceno")
		private String sequenceno;
		
		
		@Column(name = "empno")
		@JsonProperty("empno")
		private String empno;
		
		
		
		@JsonProperty("createddate")
		@Column(name = "createddate",columnDefinition = "TIMESTAMP(0)")
		private Date createddate;
		
		//@Column(name = "attendancedate")
		@JsonProperty("attendancedate")
		//@Convert(converter = LocalDateConverter.class)
		//@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "attendancedate",columnDefinition = "TIMESTAMP(0)")
		private Date attendancedate;
		
		@Column(name = "inorout")
		@JsonProperty("inorout")
		private String inorout;
		
		@Column(name = "orgname")
		@JsonProperty("orgname")
		private String orgname;
		
		
		
	
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSequenceno() {
			return sequenceno;
		}

		public void setSequenceno(String sequenceno) {
			this.sequenceno = sequenceno;
		}

		public String getEmpno() {
			return empno;
		}

		public void setEmpno(String empno) {
			this.empno = empno;
		}

		public Date getCreateddate() {
			return createddate;
		}

		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}

		public Date getAttendancedate() {
			return attendancedate;
		}

		public void setAttendancedate(Date attendancedate) {
			this.attendancedate = attendancedate;
		}

		public String getInorout() {
			return inorout;
		}

		public void setInorout(String inorout) {
			this.inorout = inorout;
		}

		public String getOrgname() {
			return orgname;
		}

		public void setOrgname(String orgname) {
			this.orgname = orgname;
		}

		@Override
		public int hashCode() {
			return Objects.hash(attendancedate, createddate, empno, id, inorout, orgname, sequenceno, status);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Biometric_AttendanceData other = (Biometric_AttendanceData) obj;
			return Objects.equals(attendancedate, other.attendancedate)
					&& Objects.equals(createddate, other.createddate) && Objects.equals(empno, other.empno)
					&& Objects.equals(id, other.id) && Objects.equals(inorout, other.inorout)
					&& Objects.equals(orgname, other.orgname) && Objects.equals(sequenceno, other.sequenceno)
					&& Objects.equals(status, other.status)
				;
		}

		@Override
		public String toString() {
			return "Biometric_AttendanceData [ id=" + id + ", status="
					+ status + ", sequenceno=" + sequenceno + ", empno=" + empno + ", createddate=" + createddate
					+ ", attendancedate=" + attendancedate + ", inorout=" + inorout + ", orgname=" + orgname + "]";
		}

		
		
	

}