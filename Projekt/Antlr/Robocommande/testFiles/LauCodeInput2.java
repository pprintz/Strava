behavior onSetup () :
    new event alwaysFalse :
        return false
    ;
;

strategy default :
    behavior onRun () :
        ahead(5)
    ;

    behavior onalwaysFalse () :
        turnGunRight(5)
    ;

    behavior onHitByBullet(hitByBulletEvent e) :
        changeStrategy("defensive")
    ;
;

strategy defensive :
    behavior onRun () :
        ahead(-5)
    ;

    behavior onHitByBullet(hitByBulletEvent e) :
        changeStrategy("default")
    ;
;