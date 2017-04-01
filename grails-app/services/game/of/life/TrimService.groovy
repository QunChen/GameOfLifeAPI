package game.of.life

import grails.transaction.Transactional

@Transactional
class TrimService {

    def trim(generation) {
        def cells=generation.cells

        def maxRow=cells.max{
            it.row
        }.row

        def minRow=cells.min{
            it.row
        }.row

        def maxCol=cells.max{
            it.col
        }.col

        def minCol=cells.min{
            it.col
        }.col

        if(!cells.findAll{
            it.row == minRow
        }.any{
            it.isAlive ==true
        }){
            cells.findAll{
                it.row==minRow
            }.each{
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }

        if(!cells.findAll{
            it.row == maxRow
        }.any{
            it.isAlive ==true
        }){
            cells.findAll{
                it.row==maxRow
            }.each{
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }

        if(!cells.findAll{
            it.col == minCol
        }.any{
            it.isAlive ==true
        }){
            cells.findAll{
                it.col == minCol
            }.each{
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }

        if(!cells.findAll{
            it.col == maxCol
        }.any{
            it.isAlive ==true
        }){
            cells.findAll{
                it.col == maxCol
            }.each{
                def cell = Cell.get(it.id)
                generation.removeFromCells(cell)
                cell.delete()
            }
        }

        generation.save()
    }
}
