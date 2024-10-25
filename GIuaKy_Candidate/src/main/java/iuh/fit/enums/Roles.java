package iuh.fit.enums;

public enum Roles {
    ADMINISTRATION((byte) 0),
    STAFF((byte) 1),
    MANAGER((byte) 2),
    EXECUTIVE((byte) 3);

    private final byte value;

    Roles(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public static Roles fromByte(byte value) {
        for (Roles role : Roles.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }
}
