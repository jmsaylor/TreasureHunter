package com.johnmsaylor.console;

import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;

import java.util.List;

public class Console {

    public static void showMap(Map map) {

        char[][] mapGrid = new char[map.mapSize][map.mapSize];

        mapGrid[map.treasurePosition.getX()][map.treasurePosition.getY()] = 'T';

        for (var player : map.getPlayers()) {
            mapGrid[player.position.getX()][player.position.getY()] = player.getName().charAt(0);
        }

        for (int x = 0; x < mapGrid.length; x++) {
            for (int y = 0; y < mapGrid.length; y++) {
                if (mapGrid[x][y] >= 'A') {
                    System.out.print(" " + mapGrid[x][y] + " ");
                } else {
                    System.out.print(" o ");
                }
                }
            System.out.println();
            }
        }
    }
