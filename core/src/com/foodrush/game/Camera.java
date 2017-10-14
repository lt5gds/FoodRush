package com.foodrush.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class Camera {
    private static final float SCALE_RATE = 100;
    private float MOVE_RATE;
    private static final float ROTATION_RATE = 45;
    private static final float INITIAL_ZOOM = 1f;

    private OrthographicCamera overviewCamera;
    public OrthographicCamera closeupCamera;
    private boolean inCloseupMode = true;

    public Camera() {
        overviewCamera = new OrthographicCamera();
        closeupCamera = new OrthographicCamera();
        float width=800;
        float height=600;
        MOVE_RATE=200;
//        closeupCamera.setToOrtho(false, Gdx.graphics.getWidth() * INITIAL_ZOOM, Gdx.graphics.getHeight() * INITIAL_ZOOM);
//        overviewCamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        closeupCamera.setToOrtho(false, width * INITIAL_ZOOM, height* INITIAL_ZOOM);
        overviewCamera.setToOrtho(false, width, height);

//        closeupCamera.translate(4000-(width*INITIAL_ZOOM)/2,3000-(height-INITIAL_ZOOM)/2);
    }

    public void resize(float width, float height) {
        overviewCamera.setToOrtho(false, width, height);
    }

    public void CameraMoveLet(float delta){
        closeupCamera.translate(-MOVE_RATE * delta, 0);
        closeupCamera.update();
    }
    public void CameraMoveRight(float delta){
        closeupCamera.translate(MOVE_RATE * delta, 0);
        closeupCamera.update();
    }
    public void CameraMoveDown(float delta){
        closeupCamera.translate(0,-MOVE_RATE * delta);
        closeupCamera.update();
    }
    public void CameraMoveUp(float delta){
        closeupCamera.translate(0,MOVE_RATE * delta);
        closeupCamera.update();
    }

    public Vector2 getLoc(){
        return new Vector2(closeupCamera.position.x,closeupCamera.position.y);
    }
    public void setLoc(float x,float y){
        closeupCamera.translate(x,y);
    }
    public void setMoverate(float m){
        MOVE_RATE=m;
    }
    public float getMoverate(){
        return MOVE_RATE;
    }
}
