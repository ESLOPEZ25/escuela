package com.proyect.colegio.model

import javax.persistence.*

@Entity
@Table(name = "student")

class Student {



        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var name: String? = null
        var lastname: String? = null
    }

