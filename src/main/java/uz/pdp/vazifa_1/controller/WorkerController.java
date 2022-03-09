package uz.pdp.vazifa_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.DepartmentDto;
import uz.pdp.vazifa_1.payload.WorkerDto;
import uz.pdp.vazifa_1.service.DepartmentService;
import uz.pdp.vazifa_1.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping
    public HttpEntity<?> getAll() {
        ApiResponse response = workerService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = workerService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody WorkerDto workerDto) {
        ApiResponse apiResponse = workerService.saveOrEdit(workerDto);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody WorkerDto workerDto) {
        ApiResponse apiResponse = workerService.saveOrEdit(workerDto);
        return ResponseEntity.status(202).body(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = workerService.delete(id);
        return ResponseEntity.status(200).body(apiResponse);
    }
}
