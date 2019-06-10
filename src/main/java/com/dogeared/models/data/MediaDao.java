package com.dogeared.models.data;

import com.dogeared.models.Media;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface MediaDao extends CrudRepository<Media, Integer> {

  List<Media> findByUserUid(int userUid);
}
