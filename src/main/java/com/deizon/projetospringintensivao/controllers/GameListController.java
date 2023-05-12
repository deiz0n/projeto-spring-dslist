package com.deizon.projetospringintensivao.controllers;

import com.deizon.projetospringintensivao.dto.GameListDTO;
import com.deizon.projetospringintensivao.dto.GameMinDTO;
import com.deizon.projetospringintensivao.entities.GameList;
import com.deizon.projetospringintensivao.service.GameListService;
import com.deizon.projetospringintensivao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> list = gameListService.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> list = gameService.findByList(listId);
        return list;
    }
}
