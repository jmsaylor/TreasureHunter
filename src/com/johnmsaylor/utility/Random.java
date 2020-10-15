package com.johnmsaylor.utility;

import com.johnmsaylor.map.Position;

import java.util.List;

public interface Random {
    List<Position> obstacles(int totalObstacles, int mapSize);
    Position treasurePosition(int mapSize);
    Position playerPosition(int mapSize);
}
