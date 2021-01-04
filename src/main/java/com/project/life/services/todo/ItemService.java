package com.project.life.services.todo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.life.models.todo.Item;
import com.project.life.repositories.todo.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);

	}

	public Item findItemById(Long id) {
		Optional<Item> i = itemRepository.findById(id);
		if(i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}

	public void deleteItem(Item item) {
		itemRepository.delete(item);
		
	}
}
