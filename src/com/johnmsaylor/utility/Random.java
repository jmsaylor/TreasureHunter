package com.johnmsaylor.utility;

import com.johnmsaylor.map.Position;

import java.util.List;

public interface Random {
    List<Position> randomObstacles(int totalObstacles, int mapSize);
    Position randomTreasure(int mapSize);
    Position randomPlayerPosition(int mapSize);
}
