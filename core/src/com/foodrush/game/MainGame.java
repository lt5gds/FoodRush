package com.foodrush.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class MainGame implements Screen {

    ShapeRenderer renderer;
    SpriteBatch batch;
    Camera Camera;
    Texture img;
    InputController control;
    Map map;
    Aisha aisha;
    float ws,hs;

    final FoodRushGame game;

    public MainGame(final FoodRushGame game){
        this.game=game;
    }





    @Override
    public void show() {
        ws=Gdx.graphics.getWidth();
        hs=Gdx.graphics.getHeight();
        renderer = new ShapeRenderer();
        Camera = new Camera();
        batch=new SpriteBatch();
        control = new InputController();
        control.create();
        map= new Map();

        map.create();
        Camera.setLoc(map.widthMap/2-(ws/2),map.heightMap/2-(hs/2));
        aisha=new Aisha();
        aisha.create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(control.btnUp){
            if(checkCollision(0)) {
                Camera.CameraMoveUp(delta);
            }
            aisha.setRun(true);
            aisha.AishaUp();
        }
        if (control.btnDown){
            if(checkCollision(1)) {
                Camera.CameraMoveDown(delta);
            }
            aisha.setRun(true);
            aisha.AishaDown();
        }
        if (control.btnLeft){
            if(checkCollision(2)) {
                Camera.CameraMoveLet(delta);
            }
            aisha.setRun(true);
            aisha.AishaLeft();
        }
        if (control.btnRight){
            if(checkCollision(0)) {
                Camera.CameraMoveRight(delta);
            }
            aisha.setRun(true);
            aisha.AishaRight();
        }
        Vector2 loc=Camera.getLoc();
        batch.setProjectionMatrix(Camera.closeupCamera.combined);
        map.DrawMap(batch);


        aisha.drawAisha(delta);

        control.render();
        aisha.setRun(false);
    }

    @Override
    public void resize(int width, int height) {
        Camera.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public boolean checkCollision(int dir){
        Vector2 cv=Camera.getLoc();

        float posx=cv.x+(ws/2)-32;
        float posy=cv.y+(hs/2)-32;
        float dx = 0,dy=0,cx=0,cy=0;

        for (Collision colm:map.collisions){
            Vector2 poscoll=colm.getLocCollision();
            cx=poscoll.x;
            cy=poscoll.y;
            if(dir==1) {
                cx += colm.getSizeX();
            }else if(dir==2){
                cy+=colm.getSizeY();
            }else {
                ;
            }
            dx=Math.abs(posx-cx);
            dy=Math.abs(posy-cy);
            if(dx < 1 && dy < 1){
                System.out.print("collision ");
                System.out.print(dx);
                System.out.print(" : ");
                System.out.println(dy);
                return false;
            }

        }
        System.out.print(posx);
        System.out.print(" , ");
        System.out.print(posy);
        System.out.print(" - ");
        System.out.print(cx);
        System.out.print(" , ");
        System.out.println(cy);
        System.out.print(" = ");
        System.out.print(dx);
        System.out.print(" , ");
        System.out.println(dy);
        return true;
    }
}
