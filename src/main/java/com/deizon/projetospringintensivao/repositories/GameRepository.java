package com.deizon.projetospringintensivao.repositories;

import com.deizon.projetospringintensivao.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
