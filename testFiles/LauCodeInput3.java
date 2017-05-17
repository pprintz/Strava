behavior onSetup () :
    setGunColor(Color.red)
;

strategy default :
    behavior onRun () :
        fire(1)
    ;

    behavior onHitByBullet(hitByBulletEvent e) :
        changeStrategy("aggressive")
    ;
;

strategy aggressive :
    behavior onRun () :
        rotate(-5)
    ;

    behavior onHitByBullet(hitByBulletEvent e) :
        changeStrategy("defensive")
    ;
;

strategy defensive :
    behavior onRun () :
        rotate(5)
    ;

    behavior onHitByBullet(hitByBulletEvent e) :
        changeStrategy("default")
    ;
;