package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.Address;

public record AddressDTO(String street, String number, String complement, String neighborhood, String city, String state, String zip) {
    public AddressDTO(@Valid @NotNull Address address) {
        this(address.getStreet(), address.getNumber(), address.getComplement(), address.getNeighborhood(),
                address.getCity(), address.getState(), address.getZip());
    }
}
