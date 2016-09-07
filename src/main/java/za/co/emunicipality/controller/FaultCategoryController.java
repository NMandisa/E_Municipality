package za.co.emunicipality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.emunicipality.domain.FaultCategory;
import za.co.emunicipality.service.FaultCategoryService;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
@CrossOrigin(allowedHeaders = {"*" }, origins = "*")
@RestController
@RequestMapping(value = "/faultsCategory")
public class FaultCategoryController {

    @Autowired
    FaultCategoryService  faultCategoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET,headers="Accept=application/json")
    public List<FaultCategory> getAllFaultCategory() {
        return faultCategoryService.getAllFaultCategory();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity<FaultCategory> saveFault(@RequestBody FaultCategory faultCategory) {
        faultCategoryService.saveFaultCategory(faultCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
