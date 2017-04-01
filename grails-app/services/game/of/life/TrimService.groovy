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

        while(true){
            def isRemoved=removeBoundaryCells(cells, minRow,"row", generation)
            if(!isRemoved){
                break
            }else{
                minRow++
            }
        }

        while(true){
            def isRemoved=removeBoundaryCells(cells, minCol,"col", generation)
            if(!isRemoved){
                break
            }else{
                minCol++
            }
        }

        while(true){
            def isRemoved=removeBoundaryCells(cells, maxCol,"col", generation)
            if(!isRemoved){
                break
            }else{
                maxCol--
            }
        }

        while(true){
            def isRemoved=removeBoundaryCells(cells, maxRow,"row", generation)
            if(!isRemoved){
                break
            }else{
                maxRow--
            }
        }

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
    private boolean removeBoundaryCells(cells, int boundaryValue,String type, generation) {
        boolean isRemoved=false

        if (!cells.findAll {
            it.properties[type] == boundaryValue
        }.any {
            it.isAlive == true
        }) {
            isRemoved=true
            cells.findAll {
                it.properties[type] == boundaryValue
            }.each {
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }
        isRemoved
    }

}
