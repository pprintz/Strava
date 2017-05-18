strategy default :
    behavior onRun () :
        move(765)
        log("hello world")
        rotate(2)
    ;
;

//behavior onSetup () :
////    setGunColor(Color.red)
//
//    new event AlwaysTrue1 :
//        return true
//    ;
//
//    new event AlwaysTrue2 :
//        return true
//    ;
//;
//
//strategy default :
//    behavior onRun () :
//        fire(1)
//    ;
//
//    behavior onAlwaysTrue1 () :
//        num i := 0
//        loop while i != 100:
//            log("loop 1")
//            log(i)
//            i := i + 1
//        ;
//    ;
//
//    behavior onAlwaysTrue2 () :
//        num i := 0
//        loop while i != 100:
//            log("loop 2")
//            log(i)
//            i := i + 1
//        ;
//    ;
//
//    behavior onHitByBullet(hitByBulletEvent e) :
//        changeStrategy("aggressive")
//    ;
//;
//
//strategy aggressive :
//    behavior onRun () :
//        rotate(-5)
//    ;
//
//    behavior onHitByBullet(hitByBulletEvent e) :
//        changeStrategy("defensive")
//    ;
//;
//
//strategy defensive :
//    behavior onRun () :
//        rotate(5)
//    ;
//
//    behavior onHitByBullet(hitByBulletEvent e) :
//        changeStrategy("default")
//    ;
//;