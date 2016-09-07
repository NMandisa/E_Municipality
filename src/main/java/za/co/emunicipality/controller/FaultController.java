package za.co.emunicipality.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.emunicipality.domain.Fault;
import za.co.emunicipality.domain.User;
import za.co.emunicipality.dto.SearchFaultDTO;
import za.co.emunicipality.service.FaultService;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 8/1/2016.
 */
@CrossOrigin(allowedHeaders = {"*" }, origins = "*")
@RestController
@RequestMapping(value = "/faults")
public class FaultController {

    @Autowired
    FaultService faultService;

    @RequestMapping(value = "/", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Fault> getAllFaults() {
        return faultService.getAllFaults();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity<Fault> saveFault(@RequestBody Fault fault) {
        faultService.saveFault(fault);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    List <Fault> searchFaultList;
    @RequestMapping(value = "/search", method = RequestMethod.POST,headers="Accept=application/json")
    public List<Fault> findByFaultStatus (@RequestBody SearchFaultDTO searchFaultDTO) {
        return searchFaultList =faultService.findByFaultStatus(searchFaultDTO.getFaultStatus());
    }
    @RequestMapping(value = "/getSearch", method = RequestMethod.GET,headers="Accept=application/json")
    public ResponseEntity<?> getSearchResults () {
        return new ResponseEntity<>(searchFaultList,HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> findByUserId(@PathVariable("id") Long id) {
        List <Fault> faultList =faultService.findByUserId(id);
        return new ResponseEntity<>(faultList,HttpStatus.OK);
    }


}
