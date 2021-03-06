package com.johnmsaylor.utility;

import com.johnmsaylor.map.Position;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneration implements Random {
    private java.util.Random random = new java.util.Random();

    public List<Position> obstacles(int totalObstacles, int mapSize){
        mapSize--;
        List<Position> obstacleList = new ArrayList<>();
        for (int obstacle = 0; obstacle < totalObstacles; obstacle++) {
            int xPos = random.nextInt(mapSize);
            int yPos = random.nextInt(mapSize);
            obstacleList.add(new Position(xPos,yPos));
        }
        return obstacleList;
    }

    public Position treasurePosition(int mapSize) {
        int xPos = random.nextInt(mapSize);
        int yPos = random.nextInt(mapSize);
        return new Position(xPos,yPos);
    }

    @Override
    public Position playerPosition(int mapSize) {
        int xPos = random.nextInt(mapSize);
        int yPos = random.nextInt(mapSize);
        return new Position(xPos,yPos);
    }
}
