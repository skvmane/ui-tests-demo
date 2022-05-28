package models.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class UserModel {
    @NonNull
    private final String email;
    @NonNull
    private final String password;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    private final int dayOfBirth;
    private final int monthOfBirth;
    private final int yearOfBirth;
    @NonNull
    private final String company;
    @NonNull
    private final String addressMain;
    @NonNull
    private final String addressSecond;
    @NonNull
    private final String city;
    @NonNull
    private final String postcode;
    @NonNull
    private final String additionalInfo;
    @NonNull
    private final String phone;
    @NonNull
    private final String phoneMobile;
    @NonNull
    private final int state;
    private final int country;
    @NonNull
    private final String addressAlias;

    public static UserModelBuilder builder(final String email, final String password) {
        return new UserModelBuilder().email(email).password(password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserModel:");
        sb.append("email=").append(email).append(System.lineSeparator());
        sb.append("password=").append(password).append(System.lineSeparator());
        sb.append("firstName=").append(firstName).append(System.lineSeparator());
        sb.append("lastName=").append(lastName).append(System.lineSeparator());
        sb.append("dayOfBirth=").append(dayOfBirth);
        sb.append("monthOfBirth=").append(monthOfBirth);
        sb.append("yearOfBirth=").append(yearOfBirth);
        sb.append("company=").append(company).append(System.lineSeparator());
        sb.append("addressMain=").append(addressMain).append(System.lineSeparator());
        sb.append("addressSecond=").append(addressSecond).append(System.lineSeparator());
        sb.append("city=").append(city).append(System.lineSeparator());
        sb.append("postcode=").append(postcode).append(System.lineSeparator());
        sb.append("additionalInfo=").append(additionalInfo).append(System.lineSeparator());
        sb.append("phone=").append(phone).append(System.lineSeparator());
        sb.append("phoneMobile=").append(phoneMobile).append(System.lineSeparator());
        sb.append("state=").append(state);
        sb.append("country=").append(country);
        sb.append("addressAlias=").append(addressAlias).append(System.lineSeparator());
        return sb.toString();
    }
}
