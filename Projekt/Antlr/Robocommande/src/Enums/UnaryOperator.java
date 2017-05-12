package Enums;

public enum UnaryOperator{
        PARANTHESIS,
        NEGATEBOOL,
        NEGATE;

        @Override
        public String toString() {
            String stringRep = "";
            switch(this){
                case NEGATE:
                    stringRep = "-";
                    break;
                case NEGATEBOOL:
                    stringRep = "not";
                    break;
                default:
                    stringRep = this.toString();
            }
            return stringRep;
        }
    }
