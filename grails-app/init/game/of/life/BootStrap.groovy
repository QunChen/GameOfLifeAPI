package game.of.life

class BootStrap {

    def init = { servletContext ->
        initBlockPattern()

    }
    def destroy = {
    }

    private initBlockPattern(){
        Pattern block=new Pattern(name: "block").save()
        Generation generationInitial=new Generation(step: 0)

        generationInitial.addToCells(new Cell(col: 1,row: 1,isAlive: true))
        generationInitial.addToCells(new Cell(col: 2,row: 1,isAlive: true))
        generationInitial.addToCells(new Cell(col: 1,row: 2,isAlive: true))
        generationInitial.addToCells(new Cell(col: 2,row: 2,isAlive: true))

        generationInitial.save()

        block.addToGenerations(generationInitial).save()
    }
}
