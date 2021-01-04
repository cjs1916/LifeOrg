package com.project.life.models.event;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.project.life.models.user.User;

@Entity
@Table(name="events")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Event name is required")
	@Size(min=3, message="Be more descriptive")
	@Size(max=255, message="Too long")
	private String name;
	
	@NotEmpty(message="Describe your event")
	private String description;
	
	private String location;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String date;
	
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date reminder;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public Event() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	public Date getReminder() {
//		return reminder;
//	}
//
//	public void setReminder(Date reminder) {
//		this.reminder = reminder;
//	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
}

//package com.project.life.models.event;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//@Entity
//@Table(name="events")
//public class Event {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	@NotEmpty(message="Event name is required")
//	@Size(min=3, message="Be more descriptive")
//	@Size(max=255, message="Too long")
//	private String name;
//	
//	@NotEmpty(message="Describe your event")
//	private String description;
//	
//	private String location;
//	
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private String date;
//	
////	@DateTimeFormat(pattern="yyyy-MM-dd")
////	private Date reminder;
//	
//	@Column(updatable=false)
//	private Date createdAt;
//	private Date updatedAt;
//	
//	public Event() {
//		
//	}
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
////	public Date getReminder() {
////		return reminder;
////	}
////
////	public void setReminder(Date reminder) {
////		this.reminder = reminder;
////	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	@PrePersist
//	protected void onCreate() {
//		this.createdAt = new Date();
//	}
//	@PreUpdate
//	protected void onUpdate() {
//		this.updatedAt = new Date();
//	}
//	
//	
//}
