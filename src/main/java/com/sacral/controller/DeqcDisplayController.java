
package com.sacral.controller;

import com.sacral.model.DeqcDisplay;
import com.sacral.service.DeqcDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deqc")
public class DeqcDisplayController {

    private final DeqcDisplayService deqcDisplayService;

    @Autowired
    public DeqcDisplayController(DeqcDisplayService deqcDisplayService) {
        this.deqcDisplayService = deqcDisplayService;
    }

    @GetMapping("/case-details/{applicationNumber}")
    public void getCaseDetails(@PathVariable String applicationNumber) {
        deqcDisplayService.getCaseDetails(applicationNumber);
    }

    @GetMapping("/product-id/{applicationNumber}")
    public void getProductId(@PathVariable String applicationNumber) {
        deqcDisplayService.getProductId(applicationNumber);
    }

    @GetMapping("/case-count/{applicationNumber}")
    public void getCaseCount(@PathVariable String applicationNumber) {
        deqcDisplayService.getCaseCount(applicationNumber);
    }

    @PostMapping("/insert-form-data/{applicationNumber}")
    public void insertFormData(@PathVariable String applicationNumber) {
        deqcDisplayService.insertFormData(applicationNumber);
    }

    @GetMapping("/qc-count")
    public void getQcCount() {
        deqcDisplayService.getQcCount();
    }
}
