package game.of.life

class Cell {

    short col
    short row
    boolean isAlive

    static mapping = {
        id genetor: 'assigned'
        version false
    }

    static namedQueries = {

        topNeighbour{
            eq 'col', col
            eq 'row', row-1
         }

        bottomNeighbour{
            eq 'col', col
            eq 'row', row+1
        }

        leftNeighbour{
            eq 'col', col-1
            eq 'row', row
        }

        rightNeighbour{
            eq 'col', col+1
            eq 'row', row
        }

        topRightNeighbour{
            eq 'col', col+1
            eq 'row', row-1
        }

        bottomRightNeighbour{
            eq 'col', col+1
            eq 'row', row+1
        }

        topLeftNeighbour{
            eq 'col', col-1
            eq 'row', row-1
        }

        bottomLeftNeighbour{
            eq 'col', col-1
            eq 'row', row+1
        }
    }

    static constraints = {
    }
}
