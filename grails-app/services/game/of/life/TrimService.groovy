package game.of.life

import grails.transaction.Transactional

@Transactional
class TrimService {

    def utilsService

    /**
     * Remove boundary if no alive cells
     * @param generation
     * @return
     */
    def trim(generation) {
        def cells=generation.cells

        def (int minRow, int maxRow, int minCol, int maxCol) = utilsService.getBoundaries(cells)

        removeBoundaryCells(cells, minRow,"row", generation)
        removeBoundaryCells(cells, minCol,"col", generation)
        removeBoundaryCells(cells, maxCol,"col", generation)
        removeBoundaryCells(cells, maxRow,"row", generation)

        generation.save()
    }

    /**
     * Remove cells in a boundary if no alive cells
     * @param cells
     * @param boundaryValue
     * @param type
     * @param generation
     * @return is the boundary removed
     */
    private void removeBoundaryCells(cells, int boundaryValue,String type, generation) {

        if (!cells.findAll {
            it.properties[type] == boundaryValue
        }.any {
            it.isAlive == true
        }) {
            cells.findAll {
                it.properties[type] == boundaryValue
            }.each {
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }
    }

}
