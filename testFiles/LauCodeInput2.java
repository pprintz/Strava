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

;

strategy aggressive :
    behavior onRun () :
        ahead(5)
    ;

    behavior onAlwaysFalse () :
        turnGunRight(5)
    ;
;