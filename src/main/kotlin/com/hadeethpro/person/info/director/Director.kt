package com.hadeethpro.person.info.director

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Director(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var name: String
)