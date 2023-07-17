package com.biometic.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "pk_employee_5id"), name = "employee_biometric")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeAndBioMetricRefNo {

	
	@Column(nullable = false, name = "id")
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	
	
	@Column(name = "employeeno")
	@JsonProperty("employeeno")
	private String employeeno;
	
	
	@Column(name = "biorefno")
	@JsonProperty("biorefno")
	private String biorefno;
	
	@Column(name = "orgname")
	@JsonProperty("orgname")
	private String orgname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeno() {
		return employeeno;
	}

	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}

	public String getBiorefno() {
		return biorefno;
	}

	public void setBiorefno(String biorefno) {
		this.biorefno = biorefno;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(biorefno, employeeno, id, orgname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeAndBioMetricRefNo other = (EmployeeAndBioMetricRefNo) obj;
		return Objects.equals(biorefno, other.biorefno) && Objects.equals(employeeno, other.employeeno)
				&& Objects.equals(id, other.id) && Objects.equals(orgname, other.orgname);
	}

	@Override
	public String toString() {
		return "EmployeeAndBioMetricRefNo [id=" + id + ", employeeno=" + employeeno + ", biorefno=" + biorefno
				+ ", orgname=" + orgname + "]";
	}
	
	
	
}
