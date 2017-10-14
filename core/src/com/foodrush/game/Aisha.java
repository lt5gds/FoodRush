package com.foodrush.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class Aisha {
    private static SpriteBatch batch = new SpriteBatch();
    private Texture img ;
    private TextureRegion[][]  aisha;
    private TextureRegion[] frame;
    private Animation<TextureRegion> movement;
    private float etime;
    private Stage stage;

    private float POSX,POSY;
    private float SIZEX,SIZEY;
    private int FACE;
    private boolean RUN;
    private float SPEED;
    private float HUNGRYLEVEL;

    private float hb;
    private float hm;
    private ShapeRenderer renderer;
    private int ws,hs;
//    Tile tile;



    public void create() {

        ws=Gdx.graphics.getWidth();
        hs=Gdx.graphics.getHeight();



        SIZEX=64;
        SIZEY=64;
        POSX=(ws/2)-(SIZEX/2);
        POSY=(hs/2)-(SIZEY/2);

        FACE=0;
        RUN=false;
        SPEED=2f;

        img =new Texture("princes.png");
        aisha=new TextureRegion[8][8];
        aisha = TextureRegion.split(img,16,16);



        stage=new Stage();
        hb=0.01f;
        hm=100;
        renderer=new ShapeRenderer();

        batch.begin();
        batch.draw(aisha[FACE][1],POSX,POSY,SIZEX,SIZEY);
        batch.end();

    }


    public void run(float delta){

        frame=new TextureRegion[2];
        frame[0]=aisha[FACE][1];
        frame[1]=aisha[FACE][2];
        movement=new Animation<TextureRegion>(SPEED/2,frame);

        batch.begin();
        batch.draw(movement.getKeyFrame(delta,true),POSX,POSY,SIZEX,SIZEY);
        batch.end();
    }


    public void stand(){
        batch.begin();
        batch.draw(aisha[FACE][1],POSX,POSY,SIZEX,SIZEY);
        batch.end();
    }

//    public  void AishaMove(){
//        etime += Gdx.graphics.getDeltaTime();
//        frame=new TextureRegion[2];
//        frame[0]=aisha[FACE][1];
//        frame[1]=aisha[FACE][2];
//        movement=new Animation(SPEED/8,frame);
//        batch.begin();
//        batch.draw((Texture) movement.getKeyFrame(etime,true),POSX,POSY,SIZEX,SIZEY);
//        batch.end();
//    }

    public void AishaUp(){
        FACE=3;
    }
    public void AishaDown(){
        FACE=0;
    }
    public void AishaLeft(){
        FACE=1;
    }
    public void AishaRight(){
        FACE=2;
    }
    public void setRun(boolean r){
        RUN=r;
    }

    public void drawAisha(float delta){
//        if(RUN){
//            run(delta);
//        }else {
//            stand();
//        }
        run(delta);
//        stand();
    }
    public void ais(){
        batch.begin();
        batch.draw(new TextureRegion(new Texture("prince.png"),0,0,16,16),ws/2,hs/2,10,100);
        batch.end();
    }

}
