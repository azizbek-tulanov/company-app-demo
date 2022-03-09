package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.CompanyDto;
import uz.pdp.vazifa_1.payload.DepartmentDto;
import uz.pdp.vazifa_1.service.CompanyService;
import uz.pdp.vazifa_1.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse response = departmentService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = departmentService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody DepartmentDto departmentDto) {
        ApiResponse apiResponse = departmentService.saveOrEdit(departmentDto);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody DepartmentDto departmentDto) {
        ApiResponse apiResponse = departmentService.saveOrEdit(departmentDto);
        return ResponseEntity.status(202).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = departmentService.delete(id);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
