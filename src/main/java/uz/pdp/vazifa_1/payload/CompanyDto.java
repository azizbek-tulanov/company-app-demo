package uz.pdp.vazifa_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Integer id;

    private String corpName;

    private String directorName;

    private AddressDto addressDto;
}
