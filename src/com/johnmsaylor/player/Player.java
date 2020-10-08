package com.johnmsaylor.player;

import com.johnmsaylor.map.Position;

public class Player {
    private String name;
    public Position position;

    public Player(String name) {
        this.name = name;
        this.position = new Position();
    }

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
