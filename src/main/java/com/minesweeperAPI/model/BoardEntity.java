package com.minesweeperAPI.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BoardEntity {

    @Id
    private int id;
    @Column(length=5000)
    private String jsonboard;

    public BoardEntity(Board board, int id){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            this.jsonboard = ow.writeValueAsString(board);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.id = id;
    }

    public Board getBoardObject(){
        ObjectMapper objectMapper = new ObjectMapper();
        Board boardobj = null;
        try {
            boardobj  = objectMapper.readValue(this.jsonboard, Board.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return boardobj;
    }


}
