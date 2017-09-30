package io.ian.calculator.repositories;

import io.ian.calculator.models.CalcUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalcUserRepository extends CrudRepository<CalcUser, Long>{
    List<CalcUser> findAllByName(String name);
    CalcUser findCalcUserByName(String name);
}
