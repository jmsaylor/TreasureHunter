package com.johnmsaylor.map;

import java.util.List;

public class MapGrid {
    public char[][] mapGrid;

    public MapGrid(List<Position> obstacles, Position treasurePosition, int mapSize) {
        mapGrid = new char[mapSize][mapSize];
        for (Position obstacle : obstacles) {
            mapGrid[obstacle.getY()][obstacle.getX()] = 'X';
        }
        mapGrid[treasurePosition.getY()][treasurePosition.getX()] = 'T';
    }

    public char[][] getMapGrid() {
        return mapGrid;
    }
}
