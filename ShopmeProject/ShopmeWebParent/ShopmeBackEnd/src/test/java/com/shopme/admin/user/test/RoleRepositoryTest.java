package com.shopme.admin.user.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopme.admin.user.RoleRepository;
import com.shopme.common.entity.Role;

import java.util.*;

@SpringBootTest
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository repository;
	
	@Test
	public void createFirstRole() {
		Role role=Role.builder()
				.name("shaukat")
				.description("manage everything")
				.build();
		
		Role saveRole = repository.save(role);
		assertThat(saveRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void createRestRoles()
	{
		Role salesRole=Role.builder()
				.name("Salesperson")
				.description("manage product price, customer, shipping, orders and sales report")
				.build();
		
		Role editorRole=Role.builder()
				.name("Editor")
				.description("manage categories, brands, product,articles and menus")
				.build();
		
		Role shipperRole=Role.builder()
				.name("Shipper")
				.description("shipper, view product, view order,update order status")
				.build();
		
		Role assistantRole=Role.builder()
				.name("Assistant")
				.description("manage questions and reviews")
				.build();
		
		repository.saveAll(List.of(salesRole,editorRole,shipperRole,assistantRole));
	}
}
