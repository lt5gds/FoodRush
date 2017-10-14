package com.foodrush.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class InputController implements ApplicationListener {
    int ws,hs;
    Stage stage;
    Texture btn1,btn2,chr;
    TextureRegion rbu,rbd, rbr,rbl,princes;
    TextureRegionDrawable dbu,dbd,dbr,dbl;
    ImageButton up,down,left,right;
    boolean btnUp,btnDown,btnLeft,btnRight;

    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;



    @Override
    public void create() {
        ws= Gdx.graphics.getWidth();
        hs=Gdx.graphics.getHeight();
        stage = new Stage(new ScreenViewport());
        btnUp=false;

//        arrow();
        joystick();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
//        prt();
        setBtn();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public void arrow(){
        btn1=new Texture("arrow.png");
        btn2=new Texture("arrow2.png");

        rbu=new TextureRegion(btn1);
        dbu=new TextureRegionDrawable(rbu);
        up=new ImageButton(dbu);
        up.setPosition(ws-120,120);
        up.setSize(70,70);
        up.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                btnUp=true;
                System.out.print(x);
                up.getImage().setColor(Color.GRAY);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                btnUp=false;
                up.getImage().setColor(Color.WHITE);

            }


        });
        stage.addActor(up);

        rbd=new TextureRegion(btn1);
        rbd.flip(false,true);
        dbd=new TextureRegionDrawable(rbd);
        down=new ImageButton(dbd);
        down.setPosition(ws-120,20);
        down.setSize(70,70);
        down.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                btnDown=true;
                down.getImage().setColor(Color.GRAY);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                down.getImage().setColor(Color.WHITE);
                btnDown=false;
            }
        });
        stage.addActor(down);

        rbr=new TextureRegion(btn2);
        dbr=new TextureRegionDrawable(rbr);
        right=new ImageButton(dbr);
        right.setPosition(120,35);
        right.setSize(70,70);
        right.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                btnRight=true;
                right.getImage().setColor(Color.GRAY);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                right.getImage().setColor(Color.WHITE);
                btnRight=false;
            }
        });
        stage.addActor(right);
        rbl=new TextureRegion(btn2);
        rbl.flip(true,false);
        dbl=new TextureRegionDrawable(rbl);
        left=new ImageButton(dbl);
        left.setPosition(20,35);
        left.setSize(70,70);
        left.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                btnLeft=true;
                left.getImage().setColor(Color.GRAY);

                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                btnLeft=false;
                left.getImage().setColor(Color.WHITE);

            }
        });
        stage.addActor(left);

        Gdx.input.setInputProcessor(stage);
    }

    public void joystick(){
        touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture("tp.png"));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture("tk.png"));

        //Create TouchPad Style
        touchpadStyle = new Touchpad.TouchpadStyle();
        //Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");

        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;

        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(ws-115, 15, 100, 100);

        stage.addActor(touchpad);
        Gdx.input.setInputProcessor(stage);
    }

    public void setBtn(){
        float x=touchpad.getKnobPercentX();
        float y=touchpad.getKnobPercentY();
        btnDown=false;
        btnUp=false;
        btnLeft=false;
        btnRight=false;
        if(x!=0||y!=0){
            if(Math.abs(x)> Math.abs(y)){
                if(x>0) btnRight=true;
                else btnLeft=true;
            }else{
                if(y>0) btnUp=true;
                else btnDown=true;
            }
        }

    }



}
