package MyRobots;

import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;

public interface Strategy{
    public void run();
    public void onHitByBullet(HitByBulletEvent e);
    public void onScannedRobot(ScannedRobotEvent e);

}
