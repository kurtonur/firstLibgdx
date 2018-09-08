package com.first.game;

import com.badlogic.gdx.InputProcessor;
import com.first.game.states.PlayState;

public class inputPlayState implements InputProcessor {

        private PlayState Ps;
    public inputPlayState(PlayState Ps){
        this.Ps=Ps;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(firstgame.GamePlay==0){
            firstgame.GamePlay=1;
            Ps.player.setSpriteRun();
        }
        else if(firstgame.GamePlay==1){
            if (Ps.player.getMoveBool()){

                if (Ps.player.move == true) {
                    Ps.player.move = false;
                    Ps.player.setSpriteJump();
                }
            }
        }else if(firstgame.GamePlay==2){
            Ps.getStateManager().pushState(new PlayState(Ps.getStateManager(),Ps.getCamera()));
            firstgame.GamePlay=1;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
