package game.of.life

import com.google.gson.Gson
import grails.rest.*
import grails.converters.*

class GenerationController extends RestfulController<Generation> {
    static responseFormats = ['json']

    def algorithmService

    GenerationController() {
        super(Generation)
    }

    def index() {

        println params

        if (params.patternId) {

            def pattern = Pattern.get(params.patternId)

            if(params.step){
                def step=Generation.findByPatternAndStep(
                        pattern, params.step)

                if (!step) {
                    algorithmService.next(
                            Generation.findByPatternAndStep(pattern,
                                    params.int('step') - 1),pattern)
                }

                respond Generation.findByPatternAndStep(
                        pattern, params.step).cells
                return
            }


            respond Generation.findAllByPattern(pattern)

            return

        } else {
            super.index(10)
        }

    }

}
