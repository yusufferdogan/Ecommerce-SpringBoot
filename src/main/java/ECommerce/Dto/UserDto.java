package ECommerce.Dto;

import ECommerce.Domains.User;
import lombok.Getter;

@Getter
public record UserDto(String firstName, String lastName) {

    public static Boolean isSameUser(UserDto first, User second) {
        return (first.firstName().toLowerCase() + first.lastName().toLowerCase()).
                equals(second.getFirstName().toLowerCase() + second.getLastName().toLowerCase());
    }
}
