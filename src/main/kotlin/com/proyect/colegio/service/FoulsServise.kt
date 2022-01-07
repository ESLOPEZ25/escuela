package com.proyect.colegio.service

import com.proyect.colegio.model.Fouls
import com.proyect.colegio.model.Inspector
import com.proyect.colegio.repository.FoulsRepository
import com.proyect.colegio.repository.InspectorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class FoulsServise {
    @Autowired
    lateinit var foulsRepository: FoulsRepository

    @Autowired
    lateinit var inspectorRepository: InspectorRepository

    fun list(): List<Fouls> {

        return foulsRepository.findAll()
    }


    fun save(fouls: Fouls): Fouls{
        try {
            inspectorRepository.findById(fouls.inspectorId)
                ?: throw Exception("Inspector no exist")

            return foulsRepository.save(fouls)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(fouls: Fouls): Fouls{

        try {
            val response = foulsRepository.findById(fouls.id)
                ?: throw  Exception (" No existe el id del inspector")
            response.apply {
                description= fouls.description
                data = fouls.data

            }
            return  foulsRepository.save(response)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun updateDescription (fouls: Fouls): Fouls {
        try {
            if (fouls.description.equals("")){
                throw java.lang.Exception("description no puede ser vacio")
            }
            val response = foulsRepository.findById(fouls.id)
                ?: throw Exception("El id ${fouls.id} en dieta no existe")
            response.apply {
                this.description = fouls.description
            }
            return foulsRepository.save(fouls)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        foulsRepository.deleteById(id)
        return true
    }
}

