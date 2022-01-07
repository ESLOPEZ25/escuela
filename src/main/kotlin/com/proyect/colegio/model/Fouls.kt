package com.proyect.colegio.model

import javax.persistence.*

@Entity
@Table(name = "fouls")

class Fouls {



        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var description: String? = null
        var data: String? = null
        @Column(name = "inspector_id")
        var inspectorId : Long? = null
        //var inspector_id: Int? = null

    }

