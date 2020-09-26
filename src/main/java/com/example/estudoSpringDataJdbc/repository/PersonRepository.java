package com.example.estudoSpringDataJdbc.repository;

import com.example.estudoSpringDataJdbc.model.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
//public interface PersonRepository extends CrudRepository<Person, Long> {
public interface PersonRepository extends org.springframework.data.repository.Repository<Person, Long> {
//public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    // @Query("select * from person where first_name=:firstName")
    // List<Person> findByFirstName(@Param("firstName") String firstName);
    // OU SOMENTE
    @Transactional(readOnly = true)
    List<Person> findByFirstName(@Param("firstName") String firstName);

    @Transactional(readOnly = true)
    List<Person> findAll();

    @Modifying
    @Query("INSERT INTO person (first_name, last_name)\n" +
            "VALUES\n" +
            "(:firstName,:lastName)")
    boolean create(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName);

}
