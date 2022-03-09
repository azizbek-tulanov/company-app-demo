package uz.pdp.vazifa_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.vazifa_1.entity.Address;
import uz.pdp.vazifa_1.entity.Company;
import uz.pdp.vazifa_1.payload.ApiResponse;
import uz.pdp.vazifa_1.payload.CompanyDto;
import uz.pdp.vazifa_1.repo.AddressRepo;
import uz.pdp.vazifa_1.repo.CompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    AddressRepo addressRepo;

    public ApiResponse getAll() {
        List<Company> list = companyRepo.findAll();
        return new ApiResponse(true,"All",list);
    }

    public ApiResponse getById(Integer id) {
        Optional<Company> optionalCompany = companyRepo.findById(id);
        if (optionalCompany.isPresent()) {
            return new ApiResponse(true,"By id",optionalCompany.get());
        }
        return new ApiResponse(false,"Not found");
    }

    public ApiResponse saveOrEdit(CompanyDto companyDto) {
        Company company=new Company();
        if (companyDto.getId()!=null) {
            company=companyRepo.getById(companyDto.getId());
        }
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Address address=new Address();
        if (companyDto.getId()!=null) {
            address=company.getAddress();
        }
        address.setHomeNumber(companyDto.getAddressDto().getHomeNumber());
        address.setStreet(companyDto.getAddressDto().getStreet());
        Address savedaddress = addressRepo.save(address);
        company.setAddress(savedaddress);
        companyRepo.save(company);
        return new ApiResponse(true,companyDto.getId()!=null?"Edited":"Saved");
    }

    public ApiResponse delete(Integer id) {
        try {
            companyRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
