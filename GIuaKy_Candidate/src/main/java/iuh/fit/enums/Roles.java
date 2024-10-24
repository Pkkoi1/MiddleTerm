package iuh.fit.enums;

public enum Roles {
    ADMINISTRATION((byte) 1),
    STAFF ((byte) 2),
    MANAGER((byte) 3),
    EXECUTIVE((byte) 4);

    private final byte value;

    Roles(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
