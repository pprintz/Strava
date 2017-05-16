behavior onSetup () :

    new event AlwaysFalse :
        return false
    ;
;


strategy default :
    behavior onRun () :
        ahead(-5)
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

	define bool getBool() :
        return true
    ;
;

strategy aggressive :
    behavior onRun () :
        ahead(5)
    ;

    define num getNum() :
        return 2
    ;

    behavior onAlwaysFalse () :
        turnGunRight(5)
    ;

    behavior onHitWall () :
        log("hey")
    ;
;