package game.of.life

import grails.transaction.Transactional

@Transactional
class UtilsService {

    /**
     * Get max row, max col, min row, min row
     * @param cells
     * @return
     */
    List getBoundaries(cells) {
        def maxRow = cells.max {
            it.row
        }.row

        def minRow = cells.min {
            it.row
        }.row

        def maxCol = cells.max {
            it.col
        }.col

        def minCol = cells.min {
            it.col
        }.col
        [minRow, maxRow, minCol, maxCol]
    }
}
