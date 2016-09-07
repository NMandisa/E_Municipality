package za.co.emunicipality.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.emunicipality.domain.Fault;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
public interface FaultRepository extends  CrudRepository <Fault,Long> {

    @Override
    List<Fault>findAll();
    List<Fault>findByFaultStatus(String faultStatus);
    List<Fault>findByUserId(Long userId);
}
