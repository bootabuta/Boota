	package net.boota.javaBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	public class Information {
		// private field
		
		@Id
		@GeneratedValue( strategy = GenerationType.IDENTITY)
		private int id;
		private String url1;
		private String url2;
		private String url3;
		private String name;
		@JsonIgnore
		private String privacy;
		private String description1;
		private String description2;
		private String description3;
		@Column(name = "create_info")
		private String createInfo;
		@Column(name = "category_id")
		@JsonIgnore
		private int categoryId;
		@Column(name = "supplier_id")
		@JsonIgnore
		private int supplierId;
		@Column(name = "view")
		private int views;
		@Column(name = "is_active")
		@JsonIgnore
		private boolean active;
		
		// Getter And Setter
		
		public boolean isActive() {
			return active;
		}


		public void setActive(boolean active) {
			this.active = active;
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


		public String getPrivacy() {
			return privacy;
		}


		public void setPrivacy(String privacy) {
			this.privacy = privacy;
		}


		public String getDescription1() {
			return description1;
		}


		public void setDescription1(String description1) {
			this.description1 = description1;
		}


		public String getDescription2() {
			return description2;
		}


		public void setDescription2(String description2) {
			this.description2 = description2;
		}


		public String getDescription3() {
			return description3;
		}


		public void setDescription3(String description3) {
			this.description3 = description3;
		}


		public String getCreateInfo() {
			return createInfo;
		}


		public void setCreateInfo(String createInfo) {
			this.createInfo = createInfo;
		}


		public int getCategoryId() {
			return categoryId;
		}


		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}


		public int getSupplierId() {
			return supplierId;
		}


		public void setSupplierId(int supplierId) {
			this.supplierId = supplierId;
		}


		public int getViews() {
			return views;
		}


		public void setViews(int views) {
			this.views = views;
		}


		public String getUrl1() {
			return url1;
		}


		public void setUrl1(String url1) {
			this.url1 = url1;
		}


		public String getUrl2() {
			return url2;
		}


		public void setUrl2(String url2) {
			this.url2 = url2;
		}


		public String getUrl3() {
			return url3;
		}


		public void setUrl3(String url3) {
			this.url3 = url3;
		}

		
		 // its for debugging purpose only
		@Override
		public String toString() {
			return "Information [id=" + id + ", url1=" + url1 + ", url2=" + url2 + ", url3=" + url3 + ", name=" + name
					+ ", privacy=" + privacy + ", description1=" + description1 + ", description2=" + description2
					+ ", description3=" + description3 + ", createInfo=" + createInfo + ", categoryId=" + categoryId
					+ ", supplierId=" + supplierId + ", views=" + views + ", active=" + active + "]";
		}



}
