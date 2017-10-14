package com.foodrush.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Alpha7 on 10/12/2017.
 */

public class FirstScreen implements Screen {
    OrthographicCamera cam;
    SpriteBatch batch;
    Texture bgc,btn,cloud1,cloud2,cloud3,fr;
    ImageButton play;
    Stage stage;
    int ws,hs;
    float ax,bx,cx,ay,by,cy;

    final FoodRushGame game;

    public FirstScreen(final FoodRushGame game){
        this.game=game;
    }
    @Override
    public void show() {
        ws= Gdx.graphics.getWidth();
        hs=Gdx.graphics.getHeight();
        cam=new OrthographicCamera(ws,hs);
        batch=new SpriteBatch();
        stage=new Stage();
        bgc=new Texture("frbg.png");
        btn=new Texture("playbtn.png");
        cloud1=new Texture("awan.png");
        cloud2= new Texture("awan2.png");
        cloud3=new Texture("awan33.png");
        fr=new Texture("fr.png");
        ax=0;
        bx=ws/2;
        cx=ws-(ws/4);
        TextureRegionDrawable pl=new TextureRegionDrawable(new TextureRegion(btn));
        play=new ImageButton(pl);
        play.setPosition((ws/2)-50,100);
        play.setSize(100,100);
        play.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                play.setPosition((ws/2)-50,90);
//                System.out.print("pencet");
//                MainGame mg=new MainGame();


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                play.setPosition((ws/2)-50,100);
                game.setScreen(new MainGame(game));
                dispose();
            }

        });
        stage.addActor(play);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(bgc,0,0,ws,hs);
        ax-=0.3;bx-=0.4;cx-=0.3;
        if(ax+cloud1.getWidth()<0){ax=ws;}
        if(bx+cloud2.getWidth()<0){bx=ws;}
        if(cx+cloud3.getWidth()<0){cx=ws;}
        batch.draw(cloud1,ax,hs-100);
        batch.draw(cloud2,bx,hs-50);
        batch.draw(cloud3,cx,hs-120);
        batch.draw(fr,(ws/2)-200,(hs/2)-50,400,100);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
}
