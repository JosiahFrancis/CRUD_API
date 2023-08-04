package com.misc.simplecrudapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misc.simplecrudapi.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
