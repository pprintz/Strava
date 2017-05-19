behavior onSetup() :
    text b := "Hello, world!"
    testStruct {text ts, num ty}
    testStruct tsd := testStruct[ts := "hello", ty := 42]
    myStruct {num q, testStruct test, text fk}
    myStruct my := myStruct[q := 5, test := tsd, fk := b]
    num c := 21
    num d := c
    c := 42
    log(d)
;

strategy default:
    behavior onHitWall(HitWallEvent e) :
        num a := 5
        a := 42
        num b := a
        TestFunc(a, 2323.53)
        TestFunc2(5)
        e.getAngle()
        num eventStuff := e.getAngle()
        a := 21
        log(b)
        rotate(e.getAngle())
    ;

    behavior onScannedRobot(ScannedRobotEvent e) :
        changeStrategy("aggressive")
    ;
;

strategy aggressive :
    behavior onBulletHit(BulletHitEvent e):
        log(5)
        rotate(5)
        rotateGun(-4.5)
        rotateRadar(234)
    ;
;

define text TestFunc(num q, num p) :
    log(5)
    return q % p
;

define text TestFunc2(num g) :
    return g
;

define text TestFunc3(testStruct struct) :
    return struct.ty
;

define text TestFunc4() :
    return "5"
;