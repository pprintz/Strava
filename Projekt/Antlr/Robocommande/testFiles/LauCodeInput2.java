strategy default :
    behavior onRun () :
        ahead(5)
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