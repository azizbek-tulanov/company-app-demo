package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.payload.AddressDto;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.CompanyDto;
import uz.pdp.vazifa_1.service.AddressService;
import uz.pdp.vazifa_1.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse response = companyService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = companyService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody CompanyDto companyDto) {
        ApiResponse apiResponse = companyService.saveOrEdit(companyDto);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody CompanyDto companyDto) {
        ApiResponse apiResponse = companyService.saveOrEdit(companyDto);
        return ResponseEntity.status(202).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = companyService.delete(id);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
