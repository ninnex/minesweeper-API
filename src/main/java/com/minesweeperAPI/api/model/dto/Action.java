package com.minesweeperAPI.api.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Action {
    private String action;
    private int x;
    private int y;

}
