package za.co.emunicipality.service;


import za.co.emunicipality.domain.FaultCategory;

import java.util.List;

/**
 * Created by N Mandisa Mkhungo on 8/1/2016.
 */
public interface FaultCategoryService{

    List<FaultCategory> getAllFaultCategory();

    FaultCategory saveFaultCategory(FaultCategory faultCategory);
}
