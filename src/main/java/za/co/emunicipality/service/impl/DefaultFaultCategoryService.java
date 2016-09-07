package za.co.emunicipality.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.emunicipality.domain.FaultCategory;
import za.co.emunicipality.repository.FaultCategoryRepository;
import za.co.emunicipality.service.FaultCategoryService;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */

@Service
public class DefaultFaultCategoryService implements FaultCategoryService{

    @Autowired
    FaultCategoryRepository faultCategoryRepository;

    @Override
    public List<FaultCategory> getAllFaultCategory() {
        return faultCategoryRepository.findAll();
    }

    @Override
    public FaultCategory saveFaultCategory(FaultCategory faultCategory){
        return faultCategoryRepository.save(faultCategory);
    }

}
