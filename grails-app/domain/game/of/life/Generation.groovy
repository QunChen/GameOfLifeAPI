package game.of.life

class Generation {

    Long id
    Long step
    Pattern pattern

    static hasMany = [cells:Cell]

    static mapping={

    }

    static constraints = {
    }
}
