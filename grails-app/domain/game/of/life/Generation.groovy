package game.of.life

class Generation {

    Long id
    Long step

    static hasMany = [cells:Cell]

    static mapping={
        version false
    }

    static constraints = {
    }
}
