package com.deizon.projetospringintensivao.controllers;

import com.deizon.projetospringintensivao.dto.GameDTO;
import com.deizon.projetospringintensivao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameDTO> findall() {
        List<GameDTO> list = gameService.findAll();
        return list;
    }

}
