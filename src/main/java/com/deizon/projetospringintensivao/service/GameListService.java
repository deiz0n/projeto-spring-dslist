package com.deizon.projetospringintensivao.service;


import com.deizon.projetospringintensivao.dto.GameListDTO;
import com.deizon.projetospringintensivao.entities.GameList;
import com.deizon.projetospringintensivao.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }
}
