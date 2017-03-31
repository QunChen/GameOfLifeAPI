package game.of.life

class Generation {

    Long step

    static hasMany = [cells:Cell]

    static mapping={
        version false
        id generator:"assigned"
    }

    static constraints = {
    }
}
