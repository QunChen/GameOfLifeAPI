package game.of.life

class Game {

    String name

    static hasMany = [generations:Generation]

    static mapping={
        version false
        id generator:"assigned"
    }


    static constraints = {
    }
}
