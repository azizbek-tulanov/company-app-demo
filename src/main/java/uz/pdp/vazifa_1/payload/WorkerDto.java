package uz.pdp.vazifa_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.vazifa_1.entity.Address;
import uz.pdp.vazifa_1.entity.Department;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    private Integer id;

    private String name;

    private String phoneNumber;

    private AddressDto addressDto;

    private Integer departmentId;
}
