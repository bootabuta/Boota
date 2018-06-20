package net.boota.javaBackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Message {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please Enter Your Name")
	@Column(name = "sender_name")
	private String senderName;
	
	@Column(name = "sender_email")
	@NotBlank(message = "Please Enter Email")
	@Email(message = "please Enter Valid Email Address")
	private String senderEmail;
	
	@Column(name = "message_subject")
	@NotBlank(message = "Please Enter Message Subject")
	private String messageSubject;
	
	@Column(name = "main_message")
	@NotBlank(message = "Please Enter Your Message")
	private String mainMessage;
	
	@Column(name = "is_read")
	private boolean read;
	
	
	// Getter And Setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getMainMessage() {
		return mainMessage;
	}
	public void setMainMessage(String mainMessage) {
		this.mainMessage = mainMessage;
	}
	public boolean getRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	
	
	// Its for debugging purpose
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", senderName=" + senderName + ", senderEmail=" + senderEmail + ", messageSubject="
				+ messageSubject + ", mainMessage=" + mainMessage + ", read=" + read + "]";
	}
	

}
