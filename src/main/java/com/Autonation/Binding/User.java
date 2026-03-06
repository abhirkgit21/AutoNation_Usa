package com.Autonation.Binding;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	@Column(name = "User_Name")
	private String username;
	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;
	@Column(name = "NewPassword")
	private String newPassword;

	@Enumerated(EnumType.STRING)
	private Role role;

	public enum Role {
		ADMIN, USER
	}

}
