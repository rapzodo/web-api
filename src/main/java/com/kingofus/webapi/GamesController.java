package com.kingofus.webapi.controllers;

import com.kingofus.webapi.service.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class GamesController {

    private CrudService gamesCrudService;

    public GamesController(@Qualifier(value = "gamesCrudService") CrudService gamesCrudService) {
        this.gamesCrudService = gamesCrudService;
    }

    @RequestMapping("/games")
    public String getGames(Model model) throws Exception {
        List all = gamesCrudService.getAll();
        if (all == null || all.size() == 0)
            throw new Exception("deu merda , nao achou nada");
        model.addAttribute("games", all);
        return "games";
    }
}
