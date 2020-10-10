package com.johnmsaylor.console;

import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.MapGrid;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;

import java.util.List;

public class Console {

    public static void showMap(Map map) {
        char[][] mapGrid = map.mapGrid.getMapGrid();
        for (var player : map.getPlayers()) {
            mapGrid[player.position.getY()][player.position.getX()] = player.getName().charAt(0);
        }


        for (int y = 0; y < mapGrid.length; y++) {
            for (int x = 0; x < mapGrid.length; x++) {
                System.out.print(mapGrid[y][x] >= 'A' ? " " + mapGrid[y][x] + " " : " o ");
                }
            System.out.println();
            }
        }
    }
