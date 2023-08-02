package com.example.demo.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class userspayload {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Username",nullable=false,length=40)
	@NotEmpty
	private String name;
	@Email
	@NotEmpty
	private String email;
	@Pattern(regexp= "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length=16)
	@Size(min=6,max=16)
	@NotEmpty
	private String password;
}
