package za.co.emunicipality.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.emunicipality.domain.FaultCategory;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
public interface FaultCategoryRepository extends CrudRepository<FaultCategory,Long> {

    @Override
    List<FaultCategory> findAll();


}
