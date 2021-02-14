package pl.coderslab.spring01hibernatekrajeew06.ut.tddz1;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> users;
    private int nextId = 1;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void create(User userToStore){
        if (userToStore.getId() > 0){
            return;
        }

        int thisId = this.nextId++;
        userToStore.setId(thisId);
        this.users.put(thisId, new User(userToStore));
    }

    public int size() {
        return this.users.size();
    }

    public User getById(int id) {
        return this.users.get(id);
    }

    public void update(User user) {
        if(user.getId() == 0){
            return;
        }

        User storedUser = this.users.get(user.getId());
        if(storedUser==null){
            throw new IllegalArgumentException("Entity not managed");
        }

        update(storedUser, user);
    }

    private void update(User storedUser, User modifiedUser) {
        storedUser.setUsername(modifiedUser.getUsername());
    }

    public void delete(User user) {
        this.users.remove(user.getId());
    }
}
