package com.prospecta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	    public Integer projectId;
	 
	    public String api;
	    
	    public String description;
	    
	    public String auth;
	   
	    public boolean https;
	    
	    public String cors;
	   
	    public String link;
	    
	    public String category;

		
		public Project( String api, String description, String auth, boolean https, String cors,
				String link, String category) {
			super();
			this.api = api;
			this.description = description;
			this.auth = auth;
			this.https = https;
			this.cors = cors;
			this.link = link;
			this.category = category;
		}


		public String getApi() {
			return api;
		}


		public void setApi(String api) {
			this.api = api;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getAuth() {
			return auth;
		}


		public void setAuth(String auth) {
			this.auth = auth;
		}


		public boolean isHttps() {
			return https;
		}


		public void setHttps(boolean https) {
			this.https = https;
		}


		public String getCors() {
			return cors;
		}


		public void setCors(String cors) {
			this.cors = cors;
		}


		public String getLink() {
			return link;
		}


		public void setLink(String link) {
			this.link = link;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}
	    
		
	    
}
