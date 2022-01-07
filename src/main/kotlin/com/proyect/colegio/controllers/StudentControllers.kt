package com.proyect.colegio.controllers

import com.proyect.colegio.model.Student
import com.proyect.colegio.service.StudentServise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class StudentControllers {

    @Autowired
    lateinit var studentServise: StudentServise

    @GetMapping
    fun list(): List<Student>{
        return studentServise.list()
    }

    @PostMapping
    fun save(@RequestBody student: Student):Student{
        return studentServise.save(student)
    }

    @PutMapping
    fun update (@RequestBody student: Student):Student {
        return studentServise.update(student)
    }

    @PatchMapping
    fun updateDescription (@RequestBody student: Student):Student{
        return studentServise.updateDescription(student)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return studentServise.delete(id)
    }


}