package net.boota.javaBackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Gellary {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please Enter Your Image Name")
	@Column(name = "name")
	private String imgName;
	
	private String code;
	
	@NotBlank(message = "Please Enter Description")
	private String description;

	private String privacy;
	
	@Column(name = "is_active")
	private boolean active;
	
	// Default Constructor
	
	public Gellary(){
		
		this.code = "IMG" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
		}
	
	// Getter And Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// its for debugging purpose only
	
	@Override
	public String toString() {
		return "Gellary [id=" + id + ", imgName=" + imgName + ", code=" + code + ", description=" + description
				+ ", privacy=" + privacy + ", active=" + active + "]";
	}
	
}
