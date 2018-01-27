package isgbd.util;

import java.util.Arrays;

/**
 * Created by maria-roxana on 27.01.2018.
 */
public enum BlockType {

    READ("R"),
    WRITE("W");

    private String value;

    private BlockType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BlockType getByValue(String value) {
        return Arrays.stream(BlockType.values())
                .filter(b -> b.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

}
