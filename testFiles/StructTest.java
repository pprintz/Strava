behavior onSetup () :
    myStruct { num a, text b }
    myStruct helloStruct := myStruct [ a := 2, b := "hey" ]
;

strategy default :
    behavior onRun () :
        num c := 91652173
        num d
        d := 190386
        log(c)

    text fa := randomNumGenerator();

    define num randomNumGenerator() :
        return 42 //guaranteed to be random
    ;
;