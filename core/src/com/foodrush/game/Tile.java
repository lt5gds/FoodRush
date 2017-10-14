package com.foodrush.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class Tile {
    private Texture tileType;
    private int size;
    private int posX;
    private int posY;


    public Tile(Texture tl,int x, int y, int s){
        tileType=tl;
        size=s;
        posX=x;
        posY=y;

    }

    public Texture getTexture(){
        return tileType;
    }
    public Vector2 getLocation(){
        return new Vector2((float)posX,(float)posY);
    }

    public int getSize(){
        return size;
    }

}
