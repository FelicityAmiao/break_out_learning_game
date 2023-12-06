package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Paddle extends GameRectangle {
  public Paddle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }
  
  public void update() {
    x = Gdx.input.getX();
    if (x <= 0) {
      x = 0;
    }
    if (x >= Gdx.graphics.getWidth() - width) {
      x = Gdx.graphics.getWidth() - width;
    }
  }
}
