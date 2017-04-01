package game.of.life

import com.google.gson.Gson
import grails.rest.*
import grails.converters.*

class GenerationController extends RestfulController<Generation>{
	static responseFormats = ['json']

    def neighbourService
    def statusService
    def formatService

    GenerationController(){
        super(Generation)
    }

    def show(){

        if(!Generation.get(params.id)){
            statusService.next(Generation.get(params.int('id')-1))
        }

        render Generation.get(params.id).cells as JSON
    }

}
