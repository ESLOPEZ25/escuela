package com.proyect.colegio.service

import com.google.gson.Gson
import com.proyect.colegio.model.Inspector
import com.proyect.colegio.repository.InspectorRepository
import org.hibernate.sql.Update
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class InspectorServiceEvaTest {
    @InjectMocks
    lateinit var inspectorServise: InspectorServise

    @Mock
    lateinit var inspectorRepository: InspectorRepository



    val  jsonString: String = File("./src/test/resuor/Inspector/crearInspector.json").readText(Charsets.UTF_8)
    val dietMock = Gson().fromJson(jsonString, Inspector::class.java)




    @Test
    fun UpdateInspectorIfExiste(){

        Mockito.`when`(inspectorRepository.findById(dietMock.id)).thenReturn(dietMock)

        Mockito.`when`(inspectorRepository.save(Mockito.any(Inspector::class.java))).thenReturn(dietMock)
        val response = inspectorServise.save(dietMock)
        Assertions.assertEquals(response.id, dietMock.id)
    }

    @Test
    fun UpdateInspectorNotExiste(){
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(inspectorRepository.save(Mockito.any(Inspector::class.java))).thenReturn(dietMock)
            val response = inspectorServise.save(dietMock)
            Assertions.assertEquals(response.id, dietMock.id)
        }
    }
}