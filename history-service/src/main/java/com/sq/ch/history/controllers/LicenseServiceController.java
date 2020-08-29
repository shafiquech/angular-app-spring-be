package com.sq.ch.history.controllers;

import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/history")
public class LicenseServiceController {


  @RequestMapping(value = "/{bikeid}", method = RequestMethod.GET)
  public List<String> getLicenses(@PathVariable("bikeid") String bikeid) {

    return Collections.singletonList("No History Found for bike ID " + bikeid);
  }


}
