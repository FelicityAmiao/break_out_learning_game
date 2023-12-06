package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;
	ArrayList<Block> blocks = new ArrayList<>();
	
	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(200, 200, 10, 12, 5);
		paddle = new Paddle(100, 30, 120, 10);
		
		int blockWidth = 63;
		int blockHeight = 20;
		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		
		paddle.update();
		paddle.draw(shape);
		
		ball.update();
		ball.draw(shape);
		ball.checkCollision(paddle);
		
		for (Block block : blocks) {
			block.draw(shape);
			ball.checkCollision(block);
		}
		
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.destroyed) {
				blocks.remove(b);
				// we need to decrement i when a ball gets removed, otherwise we skip a ball!
				i--;
			}
		}
		
		shape.end();
	}
}