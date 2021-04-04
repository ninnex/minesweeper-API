package com.minesweeperAPI.api;

import com.minesweeperAPI.model.Action;
import com.minesweeperAPI.model.Board;
import com.minesweeperAPI.services.MinesweeperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
@AllArgsConstructor
public class MinesweeperController {

    MinesweeperService minesweeperService;

    @GetMapping("/getboard")
    public Board getBoard(){
        return minesweeperService.getBoard();
    }

    @PostMapping("/play")
    public Board getBoard(@RequestBody Action action){
        return minesweeperService.play(action);
    }

    @PostMapping("/mark")
    public Board markFlag(@RequestBody Action action){
        return minesweeperService.markFag(action);
    }




}
