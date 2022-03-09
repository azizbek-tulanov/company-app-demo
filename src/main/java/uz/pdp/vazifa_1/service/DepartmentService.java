package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_1.entity.Department;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.DepartmentDto;
import uz.pdp.vazifa_1.repo.CompanyRepo;
import uz.pdp.vazifa_1.repo.DepartmentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    CompanyRepo companyRepo;

    public ApiResponse getAll() {
        List<Department> all = departmentRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getById(Integer id) {
        Optional<Department> optionalDepartment = departmentRepo.findById(id);
        if (optionalDepartment.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalDepartment.get());
    }

    public ApiResponse saveOrEdit(DepartmentDto departmentDto) {
        Department department=new Department();
        if (departmentDto.getId()!=null) {
            department=departmentRepo.getById(departmentDto.getId());
        }
        department.setName(departmentDto.getName());
        department.setCompany(companyRepo.getById(departmentDto.getCompanyId()));
        departmentRepo.save(department);
        return new ApiResponse(true,departmentDto.getId()!=null?"Edit":"Save");
    }

    public ApiResponse delete(Integer id) {
        try {
            departmentRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
