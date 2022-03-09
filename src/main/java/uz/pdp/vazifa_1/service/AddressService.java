package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_1.entity.Address;
import uz.pdp.vazifa_1.payload.AddressDto;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.repo.AddressRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    public AddressRepo addressRepo;

    public ApiResponse getAll() {
        List<Address> all = addressRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getById(Integer id) {
        Optional<Address> byId = addressRepo.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",byId.get());
    }

    public ApiResponse saveOrEdit(AddressDto addressDto) {
        Address address=new Address();
        if (addressDto.getId()!=null) {
            address=addressRepo.getById(addressDto.getId());
        }
        address.setHomeNumber(addressDto.getHomeNumber());
        address.setStreet(addressDto.getStreet());
        addressRepo.save(address);
        return new ApiResponse(true,addressDto.getId()!=null?"Edit":"Save");
    }

    public ApiResponse delete(Integer id) {
        try {
            addressRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
