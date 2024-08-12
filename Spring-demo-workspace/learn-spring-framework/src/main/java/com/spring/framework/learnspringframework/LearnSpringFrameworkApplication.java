package com.spring.framework.learnspringframework;
import com.spring.framework.learnspringframework.game.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//GamingConsole game=new Mario();
			//SuperGame game=new SuperGame();
			//	GameRunner runner=new GameRunner(game);
			//when spring manages the creation of objects it is clld as beans
			GameRunner runner = context.getBean(GameRunner.class);
			runner.run();
			
			}

}
