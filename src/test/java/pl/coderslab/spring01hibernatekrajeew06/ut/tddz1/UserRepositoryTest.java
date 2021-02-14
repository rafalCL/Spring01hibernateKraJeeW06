package pl.coderslab.spring01hibernatekrajeew06.ut.tddz1;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {
    private UserRepository repo = new UserRepository();

    @Test
    public void shouldCreate() {
        // given
        User user = new User().setUsername("ala");

        // when
        repo.create(user);

        // then
        assertEquals(1, user.getId());
        assertEquals("ala", user.getUsername());
        assertEquals(1, repo.size());

        User actual2 = repo.getById(1);
        assertNotSame(user, actual2);
        assertEquals(user.getId(), actual2.getId());
        assertEquals(user.getUsername(), actual2.getUsername());
    }

    @Test
    public void shouldNotCreateWhenHasId() {
        // given
        User user = new User().setId(2).setUsername("ela");

        // when
        repo.create(user);

        // then
        assertEquals(2, user.getId());
        assertEquals("ela", user.getUsername());
        assertEquals(0, repo.size());
    }

    @Test
    public void shouldCreateTwoEntities() {
        // given
        User user1 = new User().setUsername("ela");
        User user2 = new User().setUsername("roman");

        // when
        repo.create(user1);
        repo.create(user2);

        // then
        assertEquals(2, repo.size());
        User actual1 = repo.getById(1);
        User actual2 = repo.getById(2);

        assertNotSame(user1, actual1);
        assertEquals(user1.getId(), actual1.getId());
        assertEquals(user1.getUsername(), actual1.getUsername());

        assertNotSame(user2, actual2);
        assertEquals(user2.getId(), actual2.getId());
        assertEquals(user2.getUsername(), actual2.getUsername());
    }

    @Test
    public void shouldUpdate() {
        // given
        User user = new User().setUsername("ala");
        repo.create(user);
        final int expectedId = user.getId();
        final String expectedName = "ola";

        // when
        user.setUsername(expectedName);

        repo.update(user);

        // then
        assertEquals(1, repo.size());
        assertEquals(expectedId, user.getId());
        assertEquals(expectedName, user.getUsername());

        User actual2 = repo.getById(1);
        assertNotSame(user, actual2);
        assertEquals(user.getId(), actual2.getId());
        assertEquals(user.getUsername(), actual2.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenNotManaged() {
        // given
        User user = new User().setId(2);

        // when
        repo.update(user);
    }

    @Test
    public void shouldDelete() {
        // given
        User user = new User().setUsername("ala");
        repo.create(user);

        // when
        repo.delete(user);

        // then
        assertEquals(0, repo.size());
    }
}