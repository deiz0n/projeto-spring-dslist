package com.deizon.projetospringintensivao.service;

import com.deizon.projetospringintensivao.dto.GameDTO;
import com.deizon.projetospringintensivao.entities.Game;
import com.deizon.projetospringintensivao.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameDTO(x)).toList();
    }

}
