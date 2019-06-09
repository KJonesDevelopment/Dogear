package com.dogeared.models.data;

import com.dogeared.models.Media;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface MediaDao extends CrudRepository<Media, Integer> {

}