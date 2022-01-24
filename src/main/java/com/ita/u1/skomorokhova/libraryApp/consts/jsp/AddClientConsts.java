package com.ita.u1.skomorokhova.libraryApp.consts.jsp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class AddClientConsts {
    
    String TITLE = "New client";
    String MAIN_HEADER = "Add new client";

    String CLIENT_NAME_LABEL = "Client name";
    String CLIENT_NAME_ID = "clientName";
    String CLIENT_NAME_PLACEHOLDER = "Enter client name";
    String CLIENT_NAME_INVALID_FEEDBACK = "Please provide a name";

    String CLIENT_SURNAME_LABEL = "Client surname";
    String CLIENT_SURNAME_ID = "clientSurname";
    String CLIENT_SURNAME_PLACEHOLDER = "Enter client surname";
    String CLIENT_SURNAME_INVALID_FEEDBACK = "Please provide a surname";

    String CLIENT_PATRONYMIC_ID = "clientPatronymic";
    String CLIENT_PATRONYMIC_SWITCH_LABEL = "Provide patronymic";
    String CLIENT_PATRONYMIC_PLACEHOLDER = "Enter patronymic";
    String CLIENT_PATRONYMIC_INVALID_FEEDBACK = "Please provide a client patronymic";

    String CLIENT_PASSPORT_LABEL = "Passport id";
    String CLIENT_PASSPORT_ID = "clientPassport";
    String CLIENT_PASSPORT_PLACEHOLDER = "Enter passport id";
    String CLIENT_PASSPORT_INVALID_FEEDBACK = "Please provide a client passport id";
    String CLIENT_PASSPORT_PATTERN = "";

    String DATE_OF_BIRTH_LABEL = "Date of birth";
    String DATE_OF_BIRTH_ID = "clientDateOfBirth";
    String DATE_OF_BIRTH_INVALID_FEEDBACK = "Please provide a client date of birth";

    String CLIENT_EMAIL_LABEL = "Email";
    String CLIENT_EMAIL_ID = "clientEmail";
    String CLIENT_EMAIL_PLACEHOLDER = "Enter email";
    String CLIENT_EMAIL_INVALID_FEEDBACK = "Please provide a unique client email";
    String CLIENT_EMAIL_PATTERN = "";

    String CLIENT_ADDRESS_CITY_LABEL = "City";
    String CLIENT_ADDRESS_CITY_ID = "clientCity";
    String CLIENT_ADDRESS_CITY_PLACEHOLDER = "Enter city";
    String CLIENT_ADDRESS_CITY_INVALID_FEEDBACK = "Please provide a client city";
    String CLIENT_ADDRESS_CITY_PATTERN = "";

    String CLIENT_ADDRESS_ZIPCODE_LABEL = "Zipcode";
    String CLIENT_ADDRESS_ZIPCODE_ID = "clientZipcode";
    String CLIENT_ADDRESS_ZIPCODE_PLACEHOLDER = "Enter zipcode";
    String CLIENT_ADDRESS_ZIPCODE_INVALID_FEEDBACK = "Please provide a client zipcode";
    String CLIENT_ADDRESS_ZIPCODE_PATTERN = "";

    String CLIENT_ADDRESS_STREET_LABEL = "Street";
    String CLIENT_ADDRESS_STREET_ID = "clientStreet";
    String CLIENT_ADDRESS_STREET_PLACEHOLDER = "Enter street";
    String CLIENT_ADDRESS_STREET_INVALID_FEEDBACK = "Please provide a client street";
    String CLIENT_ADDRESS_STREET_PATTERN = "";

    String CLIENT_ADDRESS_HOUSE_LABEL = "House";
    String CLIENT_ADDRESS_HOUSE_ID = "clientHouse";
    String CLIENT_ADDRESS_HOUSE_PLACEHOLDER = "Enter house";
    String CLIENT_ADDRESS_HOUSE_INVALID_FEEDBACK = "Please provide a client house";
    String CLIENT_ADDRESS_HOUSE_PATTERN = "";

    String CLIENT_ADDRESS_APARTMENT_LABEL = "Apartment";
    String CLIENT_ADDRESS_APARTMENT_ID = "clientApartment";
    String CLIENT_ADDRESS_APARTMENT_PLACEHOLDER = "Enter apartment";
    String CLIENT_ADDRESS_APARTMENT_INVALID_FEEDBACK = "Please provide a client apartment";
    String CLIENT_ADDRESS_APARTMENT_PATTERN = "";

}
