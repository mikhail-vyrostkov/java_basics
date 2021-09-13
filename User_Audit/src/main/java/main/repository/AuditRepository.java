package main.repository;

import main.entity.AuditEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<AuditEntity, Integer> {

}
