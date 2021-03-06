package game.of.life

import grails.transaction.Transactional

@Transactional
class NeighbourService {

    /**
     * Get number of neighbours
     * @param cell
     * @param generation
     * @return
     */
    def getNoOfAlives(Cell cell,Generation generation) {

        def c = Cell.createCriteria()
        def noOfAlives=c.count(){
            eq 'generation',generation
            eq 'isAlive',true
            or{
                and{
                    eq 'row', cell.row
                    eq 'col', cell.col-1
                }
                and{
                    eq 'row', cell.row
                    eq 'col', cell.col+1
                }
                and{
                    eq 'row', cell.row+1
                    eq 'col', cell.col
                }
                and{
                    eq 'row', cell.row-1
                    eq 'col', cell.col
                }
                and{
                    eq 'row', cell.row-1
                    eq 'col', cell.col-1
                }
                and{
                    eq 'row', cell.row+1
                    eq 'col', cell.col-1
                }
                and{
                    eq 'row', cell.row-1
                    eq 'col', cell.col+1
                }
                and{
                    eq 'row', cell.row+1
                    eq 'col', cell.col+1
                }
            }
        }

        noOfAlives
    }

}
