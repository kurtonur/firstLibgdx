package com.first.game.mylib;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Background {

        private Sprite bg1,bg2,bg3;
        private Vector2 vbg1,vbg2,vbg3;
        private float Pace;
        private OrthographicCamera cam;
        private Boolean VorH;
        public Background(Boolean isH,Texture bg1, Texture bg2, Texture bg3,OrthographicCamera cam,float Pace){
            this.bg1=new Sprite();
            this.bg1.setRegion(bg1);
            //this.bg1.flip(false, true);
            this.bg2=new Sprite();
            this.bg2.setRegion(bg2);
            //this.bg2.flip(false, true);
            this.bg3=new Sprite();
            this.bg3.setRegion(bg3);
            //this.bg3.flip(false, true);
            this.Pace=Pace;
            this.cam=cam;
            this.VorH=isH;
            if(this.VorH==false) CreateVecktorH();
            else CreateVecktorV();
        }

        public Background(Boolean isH, TextureRegion bg1, TextureRegion bg2, TextureRegion bg3, OrthographicCamera cam, float Pace){
        this.bg1=new Sprite();
        this.bg1.setRegion(bg1);
        //this.bg1.flip(false, true);
        this.bg2=new Sprite();
        this.bg2.setRegion(bg2);
        //this.bg2.flip(false, true);
        this.bg3=new Sprite();
        this.bg3.setRegion(bg3);
        //this.bg3.flip(false, true);
        this.Pace=Pace;
        this.cam=cam;
        this.VorH=isH;
        if(this.VorH==false) CreateVecktorH();
        else CreateVecktorV();
        }

        public void Scrolling(SpriteBatch sb){
            if(VorH==false) ChangeVecktorH();
            else ChangeVecktorV();

            sb.draw(bg1,vbg1.x,vbg1.y);
            sb.draw(bg2,vbg2.x,vbg2.y);
            sb.draw(bg3,vbg3.x,vbg3.y);

        }
        private void CreateVecktorH(){
                vbg1=new Vector2(cam.position.x-(cam.viewportWidth/2),cam.position.y-(cam.viewportHeight/2));
                vbg2=new Vector2((cam.position.x-(cam.viewportWidth/2))+bg1.getRegionWidth(),(cam.position.y-cam.viewportHeight/2));
                vbg3=new Vector2((cam.position.x-(cam.viewportWidth/2))+bg1.getRegionWidth()+bg2.getRegionWidth(),cam.position.y-(cam.viewportHeight/2));
        }
        private void ChangeVecktorH(){
            float tempcamx=cam.position.x;
            vbg1.x=vbg1.x+Pace;
            vbg2.x=vbg2.x+Pace;
            vbg3.x=vbg3.x+Pace;

            if(tempcamx>=(bg1.getRegionWidth()*2)+vbg1.x){
                vbg1.x=vbg3.x+bg3.getRegionWidth();
            }
            if(tempcamx>=(bg2.getRegionWidth()*2)+vbg2.x){
                vbg2.x=vbg1.x+bg1.getRegionWidth();
            }
            if(tempcamx>=(bg3.getRegionWidth()*2)+vbg3.x){
               vbg3.x=vbg2.x+bg2.getRegionWidth();
            }
        }

        private void CreateVecktorV(){
            vbg1=new Vector2(cam.position.x-(cam.viewportWidth/2),cam.position.y-(cam.viewportHeight/2));
            vbg2=new Vector2(cam.position.x-(cam.viewportWidth/2),cam.position.y-(cam.viewportHeight/2)-bg1.getRegionHeight());
            vbg3=new Vector2(cam.position.x-(cam.viewportWidth/2),cam.position.y-(cam.viewportHeight/2)-bg1.getRegionHeight()-bg2.getRegionHeight());
        }
        private void ChangeVecktorV(){
            float tempcamy=cam.position.y;
            vbg1.y=vbg1.y+Pace;
            vbg2.y=vbg2.y+Pace;
            vbg3.y=vbg3.y+Pace;


            if(tempcamy<=(bg1.getRegionHeight()*-1)+vbg1.y){
                vbg1.y=vbg3.y-bg3.getRegionHeight();
            }
            if(tempcamy<=(bg2.getRegionHeight()*-1)+vbg2.y){
                vbg2.y=vbg1.y-bg1.getRegionHeight();
            }
            if(tempcamy<=(bg3.getRegionHeight()*-1)+vbg3.y){
                vbg3.y=vbg2.y-bg2.getRegionHeight();
            }
        }

        public void setPace(float speed){
            this.Pace=speed;
        }
}
