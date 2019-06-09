package com.dogeared.models.data;

import com.dogeared.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

  User findByUid(int uid);

  List<User> findAll();


}