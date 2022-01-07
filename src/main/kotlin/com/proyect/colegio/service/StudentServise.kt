package com.proyect.colegio.service

import com.proyect.colegio.model.Student
import com.proyect.colegio.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class StudentServise {
    @Autowired
    lateinit var studentRepository: StudentRepository

    fun list(): List<Student> {

        return studentRepository.findAll()
    }


    fun save(student: Student):Student{
        try {
            if (student.name?.trim()?.isEmpty() == true){
                throw Exception("El nombre no puede ser vacio")
            }
            return studentRepository.save(student)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(student: Student):Student{
        try {
            val response = studentRepository.findById(student.id)
                ?: throw  Exception (" No existe el id del estudiante")
            response.apply {
                name = student.name
                lastname = student.lastname

            }
            return  studentRepository.save(response)
        }catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun updateDescription (student: Student):Student {
        try {
            if (student.name.equals("")){
                throw java.lang.Exception("El nombre no puede ser vacio")
            }
            val response = studentRepository.findById(student.id)
                ?: throw Exception("El id ${student.id} en student no existe")
            response.apply {
                this.name = student.name
            }
            return studentRepository.save(student)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        studentRepository.deleteById(id)
        return true
    }
}

