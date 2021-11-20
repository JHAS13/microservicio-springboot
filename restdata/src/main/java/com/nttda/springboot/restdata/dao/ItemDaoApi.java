package com.nttda.springboot.restdata.dao;

import com.nttda.springboot.restdata.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDaoApi extends CrudRepository<Item,Integer> {
}
