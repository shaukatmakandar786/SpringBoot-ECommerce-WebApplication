package com.shopme.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false ,unique = true)
	private String email;
	
	@Column(length =64, nullable = false)
	private String password;
	
	@Column(length =45, nullable = false)
	private String firstName;
	
	@Column(length =45, nullable = false)
	private String lastName;
	
	@Column(length =64)
	private String photos;
	
	@ManyToMany
	@JoinTable(
				name="users_roles",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private Set<Role> roles=new HashSet<>();
	
	private boolean enabled;
	
	public void addRole(Role role)
	{
		this.roles.add(role);
	}

	public User(String email, String firstName, String lastName, String password) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	
}
