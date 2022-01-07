package com.proyect.colegio.repository

import com.proyect.colegio.model.Fouls
import org.springframework.data.jpa.repository.JpaRepository

interface FoulsRepository : JpaRepository<Fouls, Long> {
    fun findById(id: Long?): Fouls?
}