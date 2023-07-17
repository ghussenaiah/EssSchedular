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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "pk_users_7id"), name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users  implements Serializable {

	
	
		
	// //@Temporal(TemporalType.TIME)
	@Column(nullable = false, name = "id")
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	    
	@Column(name = "address")
	@JsonProperty("address")
	private String address;
	
	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "order")
	@JsonProperty("order")
	private String order;
	
	@Column(name = "date")
	@JsonProperty("date")
	private String date;
	
	
	/*
	 * @JsonProperty("date")
	 * 
	 * @Column(name = "date",columnDefinition = "TIMESTAMP(0)") private Date date;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, date, id, name, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(address, other.address) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(order, other.order);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", address=" + address + ", name=" + name + ", order=" + order + ", date=" + date
				+ "]";
	}
		

	
	
}
