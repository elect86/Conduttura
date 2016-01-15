/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author GBarbieri
 */
public enum VertexAttributeId {

    // conventional vertex attributes
    POSITION,
    VERTEX_WEIGHT,
    NORMAL,
    COLOR,
    SECONDARY_COLOR,
    FOG_COORD,
    UNUSED_1,
    UNUSED_2,
    TEXCOORD0,
    TEXCOORD1,
    TEXCOORD2,
    TEXCOORD3,
    TEXCOORD4,
    TEXCOORD5,
    TEXCOORD6, TANGENT(TEXCOORD6),
    TEXCOORD7, BINORMAL(TEXCOORD7),
    // generic vertex attributes
    ATTR0,
    ATTR1,
    ATTR2,
    ATTR3,
    ATTR4,
    ATTR5,
    ATTR6,
    ATTR7,
    ATTR8,
    ATTR9,
    ATTR10,
    ATTR11,
    ATTR12,
    ATTR13,
    ATTR14,
    ATTR15,
    COUNT(16);

    public final int value;
    
    private VertexAttributeId() {
        value = Counter.nextValue;
        Counter.nextValue++;
    }

    private VertexAttributeId(int value) {
        this.value = value;
    }

    private VertexAttributeId(VertexAttributeId vertexAttribute) {
        value = vertexAttribute.value;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }
}
