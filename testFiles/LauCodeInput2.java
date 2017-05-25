behavior onSetup () :
    person { text name }
    new event AlwaysFalse :
        return false
    ;
;


strategy default :
    behavior onRun () :
        move(-5)
        person george := person[name := "george"]
    ;
//    behavior onAlwaysFalse () :
//        log("hello from custom event")
//    ;


//    define void printStuff() :
//        log("stuff is getting printed")
//    ;
	define text getText() :
        text returnText := "hey"
        return returnText
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
        move(5)
    ;

    behavior onAlwaysFalse () :
        rotateGun(5)
    ;

    behavior onHitWall () :
        log("hey")
    ;
;