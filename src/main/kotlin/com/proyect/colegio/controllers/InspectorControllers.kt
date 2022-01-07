package com.proyect.colegio.controllers

import com.proyect.colegio.model.Inspector
import com.proyect.colegio.service.InspectorServise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/inspector")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class InspectorControllers {

    @Autowired
    lateinit var inspectorServise: InspectorServise

    @GetMapping
    fun list(): List<Inspector>{
        return inspectorServise.list()
    }

    @PostMapping
    fun save(@RequestBody inspector: Inspector):Inspector{
        return inspectorServise.save(inspector)
    }

    @PutMapping
    fun update (@RequestBody inspector: Inspector):Inspector {
        return inspectorServise.update(inspector)
    }

    @PatchMapping
    fun updateDescription (@RequestBody inspector: Inspector):Inspector{
        return inspectorServise.updateDescription(inspector)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return inspectorServise.delete(id)
    }


}