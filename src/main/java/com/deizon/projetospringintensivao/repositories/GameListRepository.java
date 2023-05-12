package com.deizon.projetospringintensivao.repositories;

import com.deizon.projetospringintensivao.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
