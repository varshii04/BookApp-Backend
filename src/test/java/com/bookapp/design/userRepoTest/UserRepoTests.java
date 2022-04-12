package com.bookapp.design.userRepoTest;

import com.bookapp.design.model.User;
import com.bookapp.design.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTests {
    @Autowired
    private UserRepo repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("varshii");
        user.setPhone("8870083943");
        user.setEmail("122014067@sastra.ac.in");
        user.setPassword("varshi555555");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

}
