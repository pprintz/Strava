behavior onSetup () :
	myStruct { num a }
	//myStruct something := myStruct[  ]
	// myStruct.a := 42
	num a := 1
	num b := 2
	// a.b := 3
	log("\t180008238")

	new event onAlwaysTrue :
		return true
	;

	new event onAlwaysFalse :
		return false
	;
;

strategy default:
	behavior onRun () :
		if a < 5 :
			ahead(10)
		; else if 5 < 3 :
			a := 4
		; else :
			back(10)
		;
		a := a + 2
	;

	behavior onAlwaysTrue () :
		log("hello from custom event")
	;

	behavior onHitByBullet(hitByBulletEvent e) :
		changeStrategy("defensive")
	;

	behavior onScannedRobot(scannedRobotEvent e) :
		changeStrategy("aggressive")
	;

	behavior onBulletHit(bulletHitEvent e) :
		num a := 5
	;

	behavior onHitWall(HitWallEvent e) :
		ahead(50)
	;
;

define void lol(myStruct rofl) :
	loop :
		log("hello from loop")
		log(2^4)
	;
;

strategy aggressive :
	behavior onRun () :
		turnGunRight(360)
		helloFuckingWorld := myStruct[a := 2]
	;

	behavior onHitByBullet(hitByBulletEvent e) :
		changeStrategy("defensive")
	;
;

define void printStuff(text a, num b) :
	log(a + b)
;

strategy defensive :
	behavior onRun() :
		rotate(360)
		printStuff("mama mia", 4)
	;

	behavior onScannedRobot(scannedRobotEvent e) :
		changeStrategy("aggressive")
	;
;
