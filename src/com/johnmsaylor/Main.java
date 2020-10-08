package com.johnmsaylor;

import com.johnmsaylor.console.Console;
import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    var player1 = new Player("John");
	    var player2 = new Player("Cliff", new Position(0,1));
	    var playerList = new ArrayList<Player>();
	    playerList.add(player1);
	    playerList.add(player2);
        var treasurePosition = new Position(3,4);

        var map = new Map(playerList, treasurePosition, 5);

        map.movePlayer(1,2);
        map.movePlayer(2,2);
        map.movePlayer(1,2);
        map.movePlayer(2,1);

        Console.showMap(map);

    }
}
