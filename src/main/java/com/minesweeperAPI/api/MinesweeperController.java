package com.minesweeperAPI.api;

import com.minesweeperAPI.api.model.dto.Action;
import com.minesweeperAPI.api.model.dto.Board;
import com.minesweeperAPI.services.MinesweeperService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MinesweeperController {

    @Autowired
    MinesweeperService minesweeperService;

    @GetMapping("/getboard")
    public Board getBoard(){
        return minesweeperService.getBoard();
    }






}
