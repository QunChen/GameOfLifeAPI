package game.of.life

class UrlMappings {

    static mappings = {

        "/generations"(resources:"generation"){

        }

        "/patterns"(resources:"pattern"){
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
