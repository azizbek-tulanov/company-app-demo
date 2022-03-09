package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_1.entity.Address;
import uz.pdp.vazifa_1.entity.Worker;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.WorkerDto;
import uz.pdp.vazifa_1.repo.AddressRepo;
import uz.pdp.vazifa_1.repo.DepartmentRepo;
import uz.pdp.vazifa_1.repo.WorkerRepo;

import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    WorkerRepo workerRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    AddressRepo addressRepo;

    public ApiResponse getAll() {
        return new ApiResponse(true,"All",workerRepo.findAll());
    }

    public ApiResponse getById(Integer id) {
        Optional<Worker> optionalWorker = workerRepo.findById(id);
        if (optionalWorker.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalWorker.get());
    }

    public ApiResponse saveOrEdit(WorkerDto workerDto) {
        Worker worker=new Worker();
        if (workerDto.getId()!=null) {
            worker=workerRepo.getById(workerDto.getId());
        }
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        worker.setDepartment(departmentRepo.getById(workerDto.getDepartmentId()));
        Address address=new Address();
        if (workerDto.getId()!=null) {
            address=worker.getAddress();
        }
        address.setHomeNumber(workerDto.getAddressDto().getHomeNumber());
        address.setStreet(workerDto.getAddressDto().getStreet());
        Address savedaddress = addressRepo.save(address);
        worker.setAddress(savedaddress);
        workerRepo.save(worker);
        return new ApiResponse(true,"Saved");
    }

    public ApiResponse delete(Integer id) {
        try {
            workerRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
