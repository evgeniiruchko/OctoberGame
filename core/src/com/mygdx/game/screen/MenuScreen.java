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
    private Vector2 v;
    private Texture Ship;

    @Override
    public void show() {
        super.show();
        background = new Texture("space.jpg");
        Ship = new Texture("sh.png");
        pos = new Vector2(100, 100);
        v = new Vector2(1, 1);
        pos.add(v);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
       // batch.draw(img, 0, 0);
        batch.draw(background, 0, 0);
        batch.draw(Ship, pos.x, pos.y,50,78);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        pos.set(screenX, 1);//Gdx.graphics.getHeight());
        return super.touchDown(screenX, screenY, pointer, button);
    }
}