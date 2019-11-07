package com.hadeethpro.person.info.director

import com.hadeethpro.person.info.Path
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(
        collectionResourceRel = "director",
        path = Path.DIRECTOR
)
interface DirectorApi : PagingAndSortingRepository<Director, Long> {
}