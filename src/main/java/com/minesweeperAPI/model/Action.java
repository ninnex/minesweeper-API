package com.minesweeperAPI.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Action {
    private String action;
    private int x;
    private int y;

}
