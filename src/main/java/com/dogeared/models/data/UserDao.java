package com.dogeared.models.data;

import com.dogeared.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

  User findByUid(int uid);

  User findByUsername(String username);

  List<User> findAll();
}
