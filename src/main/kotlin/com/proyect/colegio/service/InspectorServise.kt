package com.proyect.colegio.service

import com.proyect.colegio.model.Inspector
import com.proyect.colegio.repository.InspectorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class InspectorServise {
    @Autowired
    lateinit var inspectorRepository: InspectorRepository


    fun list(): List<Inspector> {

        return inspectorRepository.findAll()
    }



    fun save(inspector: Inspector): Inspector{
        try {

            inspector.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El nombre no debe ser vacio")


           /// if (inspector.name?.trim()?.isEmpty() == true){
              ///  throw Exception("El nombre no puede ser vacio")
            //}
            return inspectorRepository.save(inspector)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(inspector: Inspector): Inspector{

        try {
            val response = inspectorRepository.findById(inspector.id)
                ?: throw  Exception (" No existe el id del inspector")
            response.apply {
                name = inspector.name
                lastname = inspector.lastname

            }
            return  inspectorRepository.save(response)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun updateDescription (inspector: Inspector): Inspector {
        try {
            if (inspector.name.equals("")){
                throw java.lang.Exception("description no puede ser vacio")
            }
            val response = inspectorRepository.findById(inspector.id)
                ?: throw Exception("El id ${inspector.id} en dieta no existe")
            response.apply {
                this.name = inspector.name
            }
            return inspectorRepository.save(inspector)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        inspectorRepository.deleteById(id)
        return true
    }


   /* fun updateDescription (inspector: Inspector) {


        inspector.name?.takeIf { it.trim().isNotEmpty() }
            ?: throw Exception("no exixte")
        return inspectorRepository.save(inspector)
    }*/



}

