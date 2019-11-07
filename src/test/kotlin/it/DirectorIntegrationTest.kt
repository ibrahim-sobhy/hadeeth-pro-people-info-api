package it

import com.hadeethpro.person.info.Path
import com.hadeethpro.person.info.PersonalInfoApiApplication
import com.hadeethpro.person.info.director.Director
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus
import java.lang.String.join

@SpringBootTest( classes = [PersonalInfoApiApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DirectorIntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    val url: String = "/" + Path.DIRECTOR

    @Test
    fun `add new director`() {
        val entity = restTemplate.postForEntity<String>( url,
                Director(name = "Ali"), String::class)
        assertThat(entity.statusCode).isEqualTo(HttpStatus.CREATED)
    }

    @Test
    fun `get all directors`() {
        val entity = restTemplate.getForEntity<String>( url )
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `should return not found if director is not exist`() {
        val entity = restTemplate.getForEntity<String>(join("", url, "/-1"))
        assertThat(entity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }
}