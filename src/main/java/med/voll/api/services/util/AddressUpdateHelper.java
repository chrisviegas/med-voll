package med.voll.api.services.util;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.AddressDTO;
import med.voll.api.entities.Address;

import java.util.Optional;

public class AddressUpdateHelper {

    public static void updateAddress(@Valid @NotNull Address address, AddressDTO dto) {
        Optional.ofNullable(dto.street()).ifPresent(address::setStreet);
        Optional.ofNullable(dto.number()).ifPresent(address::setNumber);
        Optional.ofNullable(dto.complement()).ifPresent(address::setComplement);
        Optional.ofNullable(dto.neighborhood()).ifPresent(address::setNeighborhood);
        Optional.ofNullable(dto.city()).ifPresent(address::setCity);
        Optional.ofNullable(dto.state()).ifPresent(address::setState);
        Optional.ofNullable(dto.zip()).ifPresent(address::setZip);
    }
}
