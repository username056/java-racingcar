package domain;

import static java.text.MessageFormat.format;

public class Name {

    private final int MINIMUM_NAME_LENGTH = 1;
    private final int MAXIMUM_NAME_LENGTH = 5;
    private final String INVAILD_NAME_LENGTH_MESSAGE
            = "차의 이름은 " + MINIMUM_NAME_LENGTH + "자 이상, " + MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.";

    private final String value;

    public Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length())
            throw new IllegalArgumentException(format(INVAILD_NAME_LENGTH_MESSAGE));
    }

    public String getValue() {
        return value;
    }
}
