package com.project.life.repositories.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.life.models.todo.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findAll();
}
