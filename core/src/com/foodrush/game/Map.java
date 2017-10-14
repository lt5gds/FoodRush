package com.foodrush.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class Map {

    public Texture g,bush,berry,tree,rumah,water;
    public TextureRegion[][] grass;
    public ArrayList<Tile> tile;
    SpriteBatch batch;
    public int widthMap, heightMap,sizeTile;
    public int rowsize,colsize;
    public ArrayList<Collision> collisions;
    Texture mp;






    public void create(){
        batch=new SpriteBatch();
        g= new Texture("grass.png");
        berry=new Texture("berry.png");
        tree=new Texture("tree.png");
        rumah = new Texture("rumah.png");
        bush= new Texture("bush.png");
        water =new Texture("water.png");
        mp=new Texture("map.png");
        grass = TextureRegion.split(g,32,32);
        widthMap=4800;
        heightMap=3600;
        sizeTile=64;
        rowsize=widthMap/sizeTile;
        colsize=widthMap/sizeTile;
        tile=new ArrayList<Tile>();
        collisions=new ArrayList<Collision>();


    }


    public void DrawMap(SpriteBatch b){
        b.begin();
        b.draw(mp,-400,-400,widthMap,heightMap);
        b.draw(rumah,(widthMap/2),(heightMap/2),96,132);
        addCollision((widthMap/2),(heightMap/2),96,132);
        b.end();
    }


    public void addCollision(float x,float y, float sizeX, float sizeY){
        Collision coll=new Collision(x,y,sizeX,sizeY);
        collisions.add(coll);
    }


}
