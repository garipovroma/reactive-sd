package com.example.garipovroma.service;

import com.example.garipovroma.controller.ShopController;
import com.example.garipovroma.dto.ItemDto;
import com.example.garipovroma.model.Item;
import com.example.garipovroma.model.User;
import com.example.garipovroma.repository.ItemRepository;
import com.example.garipovroma.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShopService implements ShopController {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public ShopService(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<Item> addItem(ItemDto item) {
        Item newItem = new Item(item.getName(), item.getRublePrice());
        return itemRepository.save(newItem);
    }

    @Override
    public Flux<Item> getAllItemInUserCurrency(String userId) {
        Flux<Item> items = itemRepository.findAll();
        Mono<User> user = userRepository.findById(userId);
        return items.flatMap(item -> user.map(u -> item.getItemWithPriceInCurrency(u.getCurrencyType())));
    }
}
