package MyRobots;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kasper Dissing Bargsteen on 07/04/2017.
 */
public class StrategyRobot extends AdvancedRobot implements Strategy {

    private Strategy currentStrategy;
    private Map<String, Strategy> strategies;


    public StrategyRobot(){
        strategies = new HashMap<>();
        currentStrategy = new DefaultStrategy(this);
        strategies.put("DefaultStrategy", currentStrategy);
        strategies.put("DefensiveStrategy", new DefensiveStrategy(this));
        strategies.put("AggressiveStrategy", new AggressiveStrategy(this));

    }

    public void run(){
        while(true){
            System.out.println("Run: " + currentStrategy.toString());
            currentStrategy.run();
            execute();
        }

    }

    public void changeStrategy(String strategyName){
        Strategy newStrategy = strategies.get(strategyName);
        if(newStrategy != null){
            System.out.println("Changing to: " + strategyName);
            currentStrategy = newStrategy;
        }
    }

    public void onHitByBullet(HitByBulletEvent e){
        currentStrategy.onHitByBullet(e);
    }

    public void onScannedRobot(ScannedRobotEvent e){
        currentStrategy.onScannedRobot(e);
    }
}


class DefaultStrategy extends AdvancedRobot implements Strategy {

    StrategyRobot self;

    public DefaultStrategy(StrategyRobot self){
        this.self = self;

    }

    @Override
    public void run() {
        self.setTurnGunRight(100);
    }

    public void onHitByBullet(HitByBulletEvent e){
        self.changeStrategy("DefensiveStrategy");
    }

    public void onScannedRobot(ScannedRobotEvent e){
        if(e.getEnergy() <= 20){
            self.changeStrategy("AggressiveStrategy");
        }
        else {
            self.setBulletColor(Color.red);
            self.setFire(1);
        }
    }
}

class DefensiveStrategy extends DefaultStrategy {
    public DefensiveStrategy(StrategyRobot self) {
        super(self);
    }

    public void run(){
        self.setAhead(100);
        self.setTurnLeft(180);
        self.changeStrategy("DefaultStrategy");
    }
}

class AggressiveStrategy extends DefaultStrategy {

    public AggressiveStrategy(StrategyRobot self) {
        super(self);
    }

    public void onScannedRobot(ScannedRobotEvent e){
        self.setBulletColor(Color.cyan);
        self.setFire(3);
        if(e.getEnergy() > 20){
            self.changeStrategy("DefaultStrategy");
        }
    }
}

public interface Strategy{
    public void run();
    public void onHitByBullet(HitByBulletEvent e);
    public void onScannedRobot(ScannedRobotEvent e);

}
