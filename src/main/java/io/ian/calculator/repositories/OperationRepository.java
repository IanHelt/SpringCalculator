package io.ian.calculator.repositories;

import io.ian.calculator.models.OperationClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<OperationClass, Long>{
}
