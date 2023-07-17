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


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "pk_server_7id"), name = "server_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Server_Details  implements Serializable {

	
	
		
	// //@Temporal(TemporalType.TIME)
	@Column(nullable = false, name = "id")
	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	    
	   
		
		@Column(name = "status")
		@JsonProperty("status")
		private String status;
		
		
		@Column(name = "serverip")
		@JsonProperty("serverip")
		private String serverip;
		
		
		@Column(name = "port")
		@JsonProperty("port")
		private String port;
	
		
		@JsonProperty("createddate")
		@Column(name = "createddate",columnDefinition = "TIMESTAMP(0)")
		private Date createddate;
		
	
		
		@Column(name = "lastsequence")
		@JsonProperty("lastsequence")
		private String lastsequence;
		

		@Column(name = "servername")
		@JsonProperty("servername")
		private String servername;
		
		@Column(name = "country")
		@JsonProperty("country")
		private String country;
		
		@Column(name = "entryexit")
		@JsonProperty("entryexit")
		private String entryexit;

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

		public String getServerip() {
			return serverip;
		}

		public void setServerip(String serverip) {
			this.serverip = serverip;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public Date getCreateddate() {
			return createddate;
		}

		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}

		public String getLastsequence() {
			return lastsequence;
		}

		public void setLastsequence(String lastsequence) {
			this.lastsequence = lastsequence;
		}

		public String getServername() {
			return servername;
		}

		public void setServername(String servername) {
			this.servername = servername;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getEntryexit() {
			return entryexit;
		}

		public void setEntryexit(String entryexit) {
			this.entryexit = entryexit;
		}

		@Override
		public int hashCode() {
			return Objects.hash(country, createddate, entryexit, id, lastsequence, port, serverip, servername, status);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Server_Details other = (Server_Details) obj;
			return Objects.equals(country, other.country) && Objects.equals(createddate, other.createddate)
					&& Objects.equals(entryexit, other.entryexit) && Objects.equals(id, other.id)
					&& Objects.equals(lastsequence, other.lastsequence) && Objects.equals(port, other.port)
					&& Objects.equals(serverip, other.serverip) && Objects.equals(servername, other.servername)
					&& Objects.equals(status, other.status);
		}

		@Override
		public String toString() {
			return "Server_Details [id=" + id + ", status=" + status + ", serverip=" + serverip + ", port=" + port
					+ ", createddate=" + createddate + ", lastsequence=" + lastsequence + ", servername=" + servername
					+ ", country=" + country + ", entryexit=" + entryexit + "]";
		}

	
		
		




	
		
		
		
}
