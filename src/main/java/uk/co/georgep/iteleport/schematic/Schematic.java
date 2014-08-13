package uk.co.georgep.iteleport.schematic;

import lombok.Data;

@Data
public class Schematic {

    private final Byte[] blocks;
    private final Byte[] data;
    private final Short width;
    private final Short length;
    private final Short height;

}