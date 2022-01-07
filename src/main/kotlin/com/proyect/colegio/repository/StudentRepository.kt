package com.proyect.colegio.repository

import com.proyect.colegio.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findById(id: Long?): Student?
}