behavior onSetup () :

    new event AlwaysFalse :
        return false
    ;
;


strategy default :
    behavior onRun () :
        move(-5)
    ;
//    behavior onAlwaysFalse () :
//        log("hello from custom event")
//    ;


//    define void printStuff() :
//        log("stuff is getting printed")
//    ;
	define text getText() :
        return "hey"
    ;
	define num getNum() :
        return 2
    ;

	behavior onHitWall (hitWallEvent e) :
        rotateGun(5)
    ;

	define bool getBool() :
        return true
    ;
;

strategy aggressive :
    behavior onRun () :
        num randomNumber := getNum()
    ;

    behavior onAlwaysFalse () :
    ;

    behavior onHitWall (hitWallEvent e) :
    ;

;