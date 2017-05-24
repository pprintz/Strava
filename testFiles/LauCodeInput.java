behavior onSetup () :
    testStruct {text asd, num dfg}
    testStruct tests := testStruct[asd := "asd", dfg := 45]
	myStruct { num a, testStruct local, text g }
	myStruct something := myStruct[ a := 33, local := tests, g := "hello" ]
//    something.g := "test"
//    something.a := 42
	num ax := 1
//	num b := 2
//	 a.b := 3
	log("\t180008238")
    log(5)
	new event AlwaysTrue :
		return true
	;

;

strategy default:
	behavior onRun () :
//		if ax < 5 :
//			move(10)
//		; else if 5 < 3 :
//			ax := 4
//		; else :
//			move(-10.5)
//		;
//		ax := ax + 2
        num a := 10 % 2
        num b := 2 + 4
        num power := 2 ^ 4 + -2 * 3 / 1
        rotate(-100)
        rotate(100)
        rotateGun(250)
        rotateGun(-250)
        rotateRadar(175)
        rotateRadar(-175)
        if a = b and b = a :
            log("a is equal to b")
        ; else if b > 2 :
            log("b is greater than 2")
        ; else :
            log("else.. what?")
        ;
	;

	behavior onAlwaysTrue () :
		log("hello from custom event")
	;

    behavior onAlwaysTrue () :
    log("hello from custom event")
    ;
	behavior onHitByBullet(hitByBulletEvent e) :
		changeStrategy("defensive")
	;
	behavior onHitByBullet(hitByBulletEvent e) :
		changeStrategy("defensive")
	;

	behavior onScannedRobot(scannedRobotEvent e) :
		changeStrategy("aggressive")
	;

	behavior onBulletHit(bulletHitEvent e) :
		num y := 5
	;

	behavior onHitWall(HitWallEvent e) :
		move(50)
	;

	define text getText(testStruct a) :
        getText(testStruct[asd := "hello", dfg := 20])
        return "hey"
    ;
	define num getNum() :
        return 2
    ;

	define bool getBool() :
        return true
    ;
;

define void lol() :
	loop :
		log("hello from loop")
		log(2^4)
        move(5)
        move(-5)
	;
;

strategy aggressive :
	behavior onRun () :
		rotateGun(360)
//		helloFuckingWorld := myStruct[a := 2]
	;

	behavior onHitByBullet(hitByBulletEvent e) :
		changeStrategy("defensive")
	;
	behavior onHitByBullet(hitByBulletEvent e):
    ;


;

define void printStuff(text aq, text b) :
	log(aq + b)
    log(aq)
    log(b)
;

strategy defensive :
	behavior onRun() :
		rotate(360)
		printStuff("i", "hlo")
	;

	behavior onScannedRobot(scannedRobotEvent e) :
		changeStrategy("aggressive")
	;
;