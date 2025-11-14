package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.Address;

public record AddressDTO(

        @NotBlank
        String street,

        String number,

        String complement,

        @NotBlank
        String neighborhood,

        @NotBlank
        String city,

        @NotBlank
        String state,

        @NotBlank
        String zip
) {
    public AddressDTO(@Valid @NotNull Address address) {
        this(address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(),
                address.getCity(), address.getState(), address.getZip());
    }
}
