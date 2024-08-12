package com.spring.framework.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class GameRunner  {
	@Autowired
private  GamingConsole game;
	public GameRunner(GamingConsole game) {
	this.game=game;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub
		game.up();
		game.down();
		game.left();
		game.right();
		game.down();
	}

}
