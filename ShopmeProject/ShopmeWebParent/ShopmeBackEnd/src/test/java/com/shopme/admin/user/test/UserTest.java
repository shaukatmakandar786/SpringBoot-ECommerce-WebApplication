package com.shopme.admin.user.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.admin.user.UserRepository;
import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTest {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUserWithOneRole()
	{
				
		User user=new User("abc@gmail.com","shaukat","makandar","shaukat@123");
		Role find = entityManager.find(Role.class, 1);
		user.addRole(find);
		System.out.println(user);
		User save = repository.save(user);
		assertThat(save.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateUserWithTwoRole() {
		
		User user=new User("pqr@gmail.com","wasim","khan","wasim@123");
		Role roleEditor=new Role(3);
		Role roleAssistent=new Role(5);
		
		user.addRole(roleAssistent);
		user.addRole(roleEditor);
		
		User save = repository.save(user);
		assertThat(save.getId()).isGreaterThan(0);
		
	}
}