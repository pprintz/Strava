behavior onSetup() :
//    text b := "Hello, world!"
//    testStruct {text ts, num ty}
//    testStruct tsd := testStruct[ts := "hello", ty := 42]
//    myStruct {num q, testStruct test, text fk}
//    myStruct my := myStruct[q := 5, test := tsd, fk := b]
//    num c := 21
//    num d := c
//    c := 42
//    log(d)
;

strategy default:
    behavior onHitWall(HitWallEvent e) :
        num a := 5
//        num b := a
        TestFunc(a)
        e.getAngle()
        num eventStuff := e.getAngle()
//        a := 21
//        log(b)
        rotate(e.getAngle())
    ;

//    behavior onScannedRobot(ScannedRobotEvent e) :
//        changeStrategy("aggressive")
//    ;
//
    define text TestFunc(num a) :
        log(a)
        return a
    ;
//;
//
//strategy aggressive :
//    behavior onBulletHit(BulletHitEvent e):
//        log(5)
//        rotate(5)
//        rotateGun(-4.5)
//        rotateRadar(234)
//    ;
;