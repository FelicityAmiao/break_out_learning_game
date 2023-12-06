package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRectangle {
  int x;
  int y;
  int width;
  int height;
  
  public GameRectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void draw(ShapeRenderer shape) {
    shape.rect(x, y, width, height);
  }
}
