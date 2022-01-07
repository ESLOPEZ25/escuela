package com.proyect.colegio.repository

import com.proyect.colegio.model.Inspector
import org.springframework.data.jpa.repository.JpaRepository

interface InspectorRepository : JpaRepository<Inspector, Long> {
    fun findById(id: Long?): Inspector?
}