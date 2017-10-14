package com.foodrush.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alpha7 on 10/14/2017.
 */

public class Collision {
    private float x;
    private float y;
    private float sizeX;
    private float sizeY;
//    private int id;

    public Collision(float x,float y,float sizeX,float sizeY){
        this.x=x;
        this.y=y;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
    }
    public Vector2 getLocCollision(){
        return new Vector2(x,y);
    }
    public float getSizeX(){
        return sizeX;
    }
    public float getSizeY(){
        return sizeY;
    }

}
