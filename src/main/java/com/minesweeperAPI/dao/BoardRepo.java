package com.minesweeperAPI.dao;

import com.minesweeperAPI.model.BoardEntity;
import org.springframework.data.repository.CrudRepository;


public interface BoardRepo extends CrudRepository<BoardEntity, Integer> {
}
