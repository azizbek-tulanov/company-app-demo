package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.payload.AddressDto;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse response = addressService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = addressService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody AddressDto addressDto) {
        ApiResponse apiResponse = addressService.saveOrEdit(addressDto);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody AddressDto addressDto) {
        ApiResponse apiResponse = addressService.saveOrEdit(addressDto);
        return ResponseEntity.status(202).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = addressService.delete(id);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
