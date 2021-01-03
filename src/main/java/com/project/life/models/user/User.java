package com.project.life.models.user;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.project.life.models.note.Note;
import com.project.life.models.movie.Movie;
import com.project.life.models.todo.ToDo;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email must be valid")
	@NotEmpty(message="Email is required")
	private String email;
	
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;
	
	@NotEmpty(message = "Confirm Password is required")
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
    @Size(min=1, message="First Name is required")
    private String firstName;
    
    @NotEmpty(message="Last Name is required")
    private String lastName;
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Note> notes;
    
	@OneToMany(mappedBy="creator",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ToDo> toDos;
    @ManyToMany(cascade = {
            CascadeType.ALL
        })
        @JoinTable(
            name = "users_movies",
            joinColumns = {
                @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "movie_id")
            }
        )
	private List<Movie> movies;
	private Boolean weatherBool;
	private Boolean toDoBool;
	private Boolean calendarBool;
	private Boolean noteBool;
	private Boolean movieBool;
	private Boolean transpBool;

	
	public User() {
    }
	
	
	
	
	
    public List<Note> getNotes() {
		return notes;
	}





	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}





	public Boolean getWeatherBool() {
		return weatherBool;
	}





	public void setWeatherBool(Boolean weatherBool) {
		this.weatherBool = weatherBool;
	}





	public Boolean getToDoBool() {
		return toDoBool;
	}





	public void setToDoBool(Boolean toDoBool) {
		this.toDoBool = toDoBool;
	}





	public Boolean getCalendarBool() {
		return calendarBool;
	}





	public void setCalendarBool(Boolean calendarBool) {
		this.calendarBool = calendarBool;
	}





	public Boolean getNoteBool() {
		return noteBool;
	}





	public void setNoteBool(Boolean noteBool) {
		this.noteBool = noteBool;
	}





	public Boolean getMovieBool() {
		return movieBool;
	}





	public void setMovieBool(Boolean movieBool) {
		this.movieBool = movieBool;
	}





	public Boolean getTranspBool() {
		return transpBool;
	}





	public void setTranspBool(Boolean transpBool) {
		this.transpBool = transpBool;
	}





	public String getFirstName() {
		return firstName;
	}
    
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

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
	
	
	public List<ToDo> getToDos() {
		return toDos;
	}
	
	
	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
	}
	
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

package com.project.life.models.user;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.project.life.models.movie.Movie;
import com.project.life.models.note.Note;
import com.project.life.models.todo.ToDo;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email must be valid")
	@NotEmpty(message="Email is required")
	private String email;
	
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;
	
	@NotEmpty(message = "Confirm Password is required")
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
    @Size(min=1, message="First Name is required")
    private String firstName;
    
    @NotEmpty(message="Last Name is required")
    private String lastName;
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Note> notes;
    
	@OneToMany(mappedBy="creator",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ToDo> toDos;
    @ManyToMany(cascade = {
            CascadeType.ALL
        })
        @JoinTable(
            name = "users_movies",
            joinColumns = {
                @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "movie_id")
            }
        )
	private List<Movie> movies;
	private Boolean weatherBool;
	private Boolean toDoBool;
	private Boolean calendarBool;
	private Boolean noteBool;
	private Boolean movieBool;
	private Boolean transpBool;

	
	public User() {
    }
	
	
	
	
	
    public List<Note> getNotes() {
		return notes;
	}





	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}





	public Boolean getWeatherBool() {
		return weatherBool;
	}





	public void setWeatherBool(Boolean weatherBool) {
		this.weatherBool = weatherBool;
	}





	public Boolean getToDoBool() {
		return toDoBool;
	}





	public void setToDoBool(Boolean toDoBool) {
		this.toDoBool = toDoBool;
	}





	public Boolean getCalendarBool() {
		return calendarBool;
	}





	public void setCalendarBool(Boolean calendarBool) {
		this.calendarBool = calendarBool;
	}





	public Boolean getNoteBool() {
		return noteBool;
	}





	public void setNoteBool(Boolean noteBool) {
		this.noteBool = noteBool;
	}





	public Boolean getMovieBool() {
		return movieBool;
	}





	public void setMovieBool(Boolean movieBool) {
		this.movieBool = movieBool;
	}





	public Boolean getTranspBool() {
		return transpBool;
	}





	public void setTranspBool(Boolean transpBool) {
		this.transpBool = transpBool;
	}





	public String getFirstName() {
		return firstName;
	}
    
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
	
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

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
	
	
	public List<ToDo> getToDos() {
		return toDos;
	}
	
	
	public void setToDos(List<ToDo> toDos) {
		this.toDos = toDos;
	}
	
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
