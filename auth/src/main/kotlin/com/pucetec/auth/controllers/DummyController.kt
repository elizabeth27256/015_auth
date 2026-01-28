package com.pucetec.auth.controllers

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DummyController {

    // A este endpoint cualquiera puede acceder
    //ejemplo: healt, mostrar catalogos que no sean llenos de datos sensibles


    @GetMapping("/public")
    fun public(): Response {
        return Response ("Todo ok. Este es un endpoint publico")
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/restricted")
    fun restricted():Response {
        return Response("Todo Ok. Este es un endpoint para usuarios autenticados")
    }

    // A este endpoint solo usuarios que hayan iniciado sesion y tengan el rol de administrador
    // pueden acceder, manipular configuraciones para cualquier accion que requiera privilegios.
    @PreAuthorize("hasAuthority('Role_admin')")
    @GetMapping("/restricted/admin")
    fun admin():Response {
        return Response("Todo Ok. Este es un endpoint solo para admins")
    }


}
data class Response(val mesagge: String)