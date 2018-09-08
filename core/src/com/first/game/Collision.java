package com.first.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.first.game.mylib.Object;
import com.first.game.objects.bird;
import com.first.game.objects.mainPlayer;
import com.first.game.objects.saw;

import java.util.ArrayList;
import java.util.Random;

public class Collision {

    public void deneme(){
        ArrayList<Object> den=new ArrayList<Object>();
        den.add(new bird(new Vector2(10,10)));
        den.add(new saw(new Vector2(30,30)));
    }

    public static boolean Playerandenemys(Object player, Object enemys){
        boolean durum=false;
        if(player.getRectangle().overlaps(enemys.getRectangle()))
                durum=true;

        return durum;
    }

    public static boolean AllObject(mainPlayer player, ArrayList<Object> enemys, OrthographicCamera cam){
        boolean tut=false;
        for (int i=0;i<enemys.size();i++) {
            tut=Playerandenemys(player,enemys.get(i));
            if(tut==true) break;
            removeObject(enemys.get(i),enemys,cam);
        }
        return tut;
    }
    public static void removeObject(Object ob,ArrayList<Object> obs,OrthographicCamera cam){
        if(ob.getRectangle().x+ob.getRectangle().width+10<cam.position.x-firstgame.WIDTH/2){
            obs.remove(ob);
            addobject(obs,cam);
        }

    }
    public static void addobject(ArrayList<Object> obs,OrthographicCamera cam){
        Random ran = new Random();
        boolean tut=false;
        while(true) {
            Object d;
            if (ran.nextInt(2) == 0) {
                 d = new bird(new Vector2(cam.position.x + firstgame.WIDTH / 2 + firstgame.WIDTH / 2 + ran.nextInt(10) + 25, cam.position.y - 70));
            } else {
                 d = new saw(new Vector2(cam.position.x + firstgame.WIDTH / 2 + ran.nextInt(100) + 25, cam.position.y - 110));
            }
            for(Object ob : obs){
                if(Playerandenemys(d,ob)){
                    tut=false;
                    break;
                }
                else tut=true;

            }
            if(tut==true){
                obs.add(d);
                break;
            }
        }
    }

}
