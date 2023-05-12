package com.deizon.projetospringintensivao.service;

import com.deizon.projetospringintensivao.dto.GameDTO;
import com.deizon.projetospringintensivao.dto.GameMinDTO;
import com.deizon.projetospringintensivao.entities.Game;
import com.deizon.projetospringintensivao.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
