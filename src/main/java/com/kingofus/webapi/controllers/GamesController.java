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

    private CrudService service;

    public GamesController(@Qualifier("gamesCrudService") CrudService service) {
        this.service = service;
    }

    @RequestMapping("/games")
    public String getGames(Model model) throws Exception {
        List all = service.getAll();
        if (all == null || all.size() == 0)
            throw new Exception("deu merda , nao achou nada");
        model.addAttribute("games", all);
        return "public/games";
    }

    @RequestMapping("/shit")
    public void shit(){
        throw new RuntimeException("SHIIIIT!!");
    }
}
