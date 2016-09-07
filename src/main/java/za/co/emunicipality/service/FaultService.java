package za.co.emunicipality.service;
import za.co.emunicipality.domain.Fault;
import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
public interface FaultService {


    /**
     * This is a service to save a Fault entity
     *
     * @param Fault to save
     * @return a persisted Fault
     */
    Fault saveFault(Fault fault);

    /**
     * This is a service that returns all Fault
     *
     * @return a list of Fault
     */
    List<Fault> getAllFaults();
    List<Fault> findByFaultStatus(String faultStatus);
    List<Fault> findByUserId(Long userId);
}
