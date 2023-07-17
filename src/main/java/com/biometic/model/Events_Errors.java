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




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "pk_eventserrors_7id"), name = "events_errors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Events_Errors  implements Serializable {

	
	
		
	// //@Temporal(TemporalType.TIME)
	@Column(nullable = false, name = "id")
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	    
	@Column(name = "error")
	@JsonProperty("error")
	private String error;
		
		
	@JsonProperty("createddate")
	@Column(name = "createddate",columnDefinition = "TIMESTAMP(0)")
	private Date createddate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(createddate, error, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events_Errors other = (Events_Errors) obj;
		return Objects.equals(createddate, other.createddate) && Objects.equals(error, other.error)
				&& Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Events_Errors [id=" + id + ", error=" + error + ", createddate=" + createddate + "]";
	}
		
	
		
}