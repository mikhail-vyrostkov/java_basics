package main.repository;

import main.entity.TokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<TokenEntity, Integer> {

}
