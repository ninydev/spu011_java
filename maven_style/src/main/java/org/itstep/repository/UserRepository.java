package org.itstep.repository;

import org.itstep.models.User;
import org.itstep.repository.exceptions.EntityNotFindException;
import org.itstep.repository.interfaces.ICreatable;
import org.itstep.repository.interfaces.IEntity;
import org.itstep.repository.interfaces.IFindByEmail;
import org.itstep.repository.interfaces.IFindById;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

public class UserRepository extends AbstractRepository<User, UUID>
    implements ICreatable<User>//, IFindById<User, UUID>
    , IFindByEmail
{
    @Override
    public IEntity<?> findByEmail(String email) {
        // return this.data.stream().filter(u-> Objects.equals(u.getEmail(), email)).findFirst().get();
        return null;
    }


//    public HashSet<User> data = new HashSet<>();
//
//
//    public void add(User u) {
//        data.add(u);
//    }
//
//    public User findById(UUID id){
//        // return findByForEach(id);
//        // return findByStream(id);
//        return null;
//    }
//
//    public User findByStream(UUID id) throws EntityNotFindException {
//        try {
//            return data.stream().filter(u -> u.getId() == id).findFirst().get();
//        } catch (NoSuchElementException ex) {
//            throw new EntityNotFindException("User not find by ID");
//        }
//    }
//
//    public User findByForEach(UUID id) throws EntityNotFindException {
//        for (User u: data) {
//            if (u.getId() == id) {
//                return u;
//            }
//        }
//        throw new EntityNotFindException("User not find by ID");
//    }


}
