package game.of.life

class Pattern {

    Long id
    String name

    static hasMany = [generations:Generation]

    static mapping={

    }


    static constraints = {
    }
}
