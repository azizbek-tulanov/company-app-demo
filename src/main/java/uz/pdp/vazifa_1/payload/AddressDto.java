package uz.pdp.vazifa_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;

    private String street;

    private Integer homeNumber;
}
