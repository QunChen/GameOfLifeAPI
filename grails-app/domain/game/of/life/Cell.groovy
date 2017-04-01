package game.of.life

class Cell {

    Long id
    Integer col
    Integer row
    Boolean isAlive
    Generation generation

    static mapping = {
        version false
    }

    static constraints = {
    }
}
