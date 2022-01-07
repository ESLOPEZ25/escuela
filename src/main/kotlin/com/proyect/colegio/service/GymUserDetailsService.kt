package com.proyect.colegio.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.ArrayList

@Service
class GymUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userServise: UserServise


    override fun loadUserByUsername(username: String?): UserDetails {

        val response = userServise.getUser(username)

        return User(response?.username,"{noop}"+ response?.password, ArrayList())
    }

}