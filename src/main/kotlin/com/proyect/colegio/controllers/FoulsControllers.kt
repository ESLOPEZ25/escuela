package com.proyect.colegio.controllers

import com.proyect.colegio.model.Fouls
import com.proyect.colegio.model.Student
import com.proyect.colegio.service.FoulsServise
import com.proyect.colegio.service.StudentServise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fouls")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class FoulsControllers {

    @Autowired
    lateinit var foulsServise: FoulsServise

    @GetMapping
    fun list(): List<Fouls>{
        return foulsServise.list()
    }

    @PostMapping
    fun save(@RequestBody fouls: Fouls):Fouls{
        return foulsServise.save(fouls)
    }

    @PutMapping
    fun update (@RequestBody fouls: Fouls):Fouls {
        return foulsServise.update(fouls)
    }

    @PatchMapping
    fun updateDescription (@RequestBody fouls: Fouls):Fouls {
        return foulsServise.updateDescription(fouls)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return foulsServise.delete(id)
    }


}