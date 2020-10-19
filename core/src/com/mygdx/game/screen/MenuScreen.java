//package com.mygdx.game.screen;////public class MenuScreen {
//}
package com.mygdx.game.screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import sun.security.jgss.GSSCaller;

public class MenuScreen extends com.mygdx.game.base.BaseScreen {
    private Texture background;
    private Vector2 pos;
    private Vector2 speed;
    private Vector2 end;
    private Vector2 temp;
    private Texture Ship;
    private Texture ShipLeft;
    private Texture ShipRigth;

    @Override
    public void show() {
        super.show();
        background = new Texture("space.jpg");
        Ship = new Texture("sh.png");
        ShipLeft = new Texture("shleft.png");
        ShipRigth = new Texture("shright.png");
        pos = new Vector2(100, 100);
        speed = new Vector2(0, 0);
        end = new Vector2(0,0);
        temp = new Vector2(0,0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
       // batch.draw(img, 0, 0);
        batch.draw(background, 0, 0);
        if (speed.x == 0)
            batch.draw(Ship, pos.x, pos.y,50,78);
        if (speed.x < 0)
            batch.draw(ShipLeft, pos.x, pos.y,50,78);
        if (speed.x > 0)
            batch.draw(ShipRigth, pos.x, pos.y,50,78);

        pos.x += speed.x;
        pos.y += speed.y;

        System.out.println(end.x + "Конечная точка" +end.y);
        System.out.println(pos.x + "Текущая точка" +pos.y);
        if (Math.round(pos.x) == end.x || Math.round(pos.y) == end.y){speed.set(0,0);}

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //pos.set(screenX, 1);//Gdx.graphics.getHeight());
        end.set(screenX, Gdx.graphics.getHeight() - screenY);
        temp.set(screenX, Gdx.graphics.getHeight() - screenY);
        temp.sub(pos);
        temp.len();
        speed.x = (temp.x/temp.len());
        speed.y = (temp.y/temp.len());

        return super.touchDown(screenX, screenY, pointer, button);
    }
}