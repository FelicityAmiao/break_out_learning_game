package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
  int x;
  int y;
  int size;
  int xSpeed;
  int ySpeed;
  
  public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }
  public void update() {
    x += xSpeed;
    y += ySpeed;
    if (x < size || x > Gdx.graphics.getWidth() - size) {
      xSpeed = -xSpeed;
    }
    if (y > Gdx.graphics.getHeight() - size) {
      ySpeed = -ySpeed;
    }
  }
  public void draw(ShapeRenderer shape) {
    shape.circle(x, y, size);
  }
  
  public void checkCollision(Paddle paddle) {
    if(collidesWith(paddle)){
      ySpeed = -ySpeed;
    }
  }
  private boolean collidesWith(GameRectangle gameRectangle) {
    if (gameRectangle.x >= this.x - gameRectangle.width && gameRectangle.x <= this.x
      && (gameRectangle.y == this.y - size - gameRectangle.height || gameRectangle.y == this.y + size)) {
      return true;
    }
    return gameRectangle.y >= this.y - gameRectangle.height && gameRectangle.y <= this.y
      && (gameRectangle.x == this.x + size || gameRectangle.x == this.x - size - gameRectangle.width);
  }
  
  public void checkCollision(Block block) {
    if(collidesWith(block)){
      ySpeed = - ySpeed;
      block.destroyed = true;
    }
  }
}
