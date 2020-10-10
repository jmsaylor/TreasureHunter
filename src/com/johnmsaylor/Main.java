package com.johnmsaylor;

import com.johnmsaylor.console.Console;
import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Position> obstacles = new ArrayList<>();
        obstacles.add(new Position(1,1));
        obstacles.add(new Position(2,1));
	    var player1 = new Player("John");
	    var player2 = new Player("Cliff", new Position(1,0));
	    var playerList = new ArrayList<Player>();
	    playerList.add(player1);
	    playerList.add(player2);
        var treasurePosition = new Position(3,4);

        var map = new Map(playerList, treasurePosition, obstacles, 5);
        int[][] arr = {{1,3},{2,2}};

        map.processMove(player1, 2,2);
        map.processMove(player2,2,2);
        map.processMoves(player1, arr);



        Console.showMap(map);

    }
}
