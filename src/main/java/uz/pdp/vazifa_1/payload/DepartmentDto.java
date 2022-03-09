package uz.pdp.vazifa_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.vazifa_1.entity.Company;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Integer id;

    private String name;

    private Integer companyId;
}
