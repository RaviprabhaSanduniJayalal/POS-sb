package com.POS.SB.backend.repo;

import com.POS.SB.backend.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ItemRepo {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean activestate);

    List<Item> findAllByActiveStateEquals(boolean activeState);

    int countAllByActiveStateEquals(boolean activeState);

    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable pageable);

}
