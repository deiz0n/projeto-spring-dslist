package com.deizon.projetospringintensivao.service;


import com.deizon.projetospringintensivao.dto.GameListDTO;
import com.deizon.projetospringintensivao.entities.GameList;
import com.deizon.projetospringintensivao.projections.GameMinProjection;
import com.deizon.projetospringintensivao.repositories.GameListRepository;
import com.deizon.projetospringintensivao.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection projection = list.remove(sourceIndex);
        list.add(destinationIndex, projection);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i=min; i<=max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }
}
