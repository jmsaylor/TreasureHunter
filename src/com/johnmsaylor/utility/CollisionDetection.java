package com.johnmsaylor.utility;

import com.johnmsaylor.player.Player;

public class CollisionDetection implements Detection{

    public boolean collision(Player player, int direction, int steps, char[][] grid, char objectMarker){
        switch (direction)
        {
            case 0:
                for (int i = player.position.getY(); i >= player.position.getY() - steps; i--){
                    if (grid[i][player.position.getX()] == objectMarker){
                        return true;
                    }
                }
                break;
            case 1:
                for (int i = player.position.getX(); i <= player.position.getX() + steps; i++){
                    if (grid[player.position.getY()][i] == objectMarker){
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = player.position.getY(); i <= player.position.getY() + steps; i++){
                    if (grid[i][player.position.getX()] == objectMarker){
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = player.position.getX(); i >= player.position.getX() - steps; i--){
                    if (grid[player.position.getY()][i] == objectMarker){
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;

        //would it be more efficient to create 2d array the size of map but just for obstacles
        //to allow for easy access
//        switch (direction)
//        {
//            case 0:
//                for (Position object : objects) {
//                    if (object.getX() == currentPlayer.position.getX() && currentPlayer.position.getY() > object.getY() && currentPlayer.position.getY() + steps < object.getY());
//                }
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            default:
//        }
    }

}

