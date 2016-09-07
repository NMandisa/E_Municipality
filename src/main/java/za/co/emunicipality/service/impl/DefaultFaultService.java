package za.co.emunicipality.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.emunicipality.domain.Fault;
import za.co.emunicipality.repository.FaultRepository;
import za.co.emunicipality.service.FaultService;
import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
@Service
public class DefaultFaultService implements FaultService {

    @Autowired
    private FaultRepository faultRepository;

    @Override
    public Fault saveFault(Fault fault) {
        return faultRepository.save(fault);
    }

    @Override
    public List<Fault> getAllFaults() {
        return faultRepository.findAll();
    }

    @Override
    public List<Fault> findByFaultStatus(String faultStatus){
        return faultRepository.findByFaultStatus(faultStatus);}

    @Override
    public List<Fault> findByUserId(Long userId){

        return faultRepository.findByUserId(userId);
    }
}
