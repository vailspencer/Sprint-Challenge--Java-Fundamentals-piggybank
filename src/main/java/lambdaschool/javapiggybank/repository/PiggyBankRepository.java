package lambdaschool.javapiggybank.repository;

import lambdaschool.javapiggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface PiggyBankRepository extends CrudRepository<Coin, Long>
{


}
