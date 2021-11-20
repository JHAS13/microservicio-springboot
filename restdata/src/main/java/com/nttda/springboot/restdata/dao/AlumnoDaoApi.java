package com.nttda.springboot.restdata.dao;

import com.nttda.springboot.restdata.model.Alumno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "alumno" , collectionResourceRel = "alumnoApi")
public interface AlumnoDaoApi extends PagingAndSortingRepository<Alumno,Integer> {

     List<Alumno> findAlumnoByNota(@Param("nota") String nota, Pageable pageable);

}
