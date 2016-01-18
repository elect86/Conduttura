/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.nio.Buffer;
import java.util.HashMap;
import jglm.Vec2;
import jglm.Vec3;

/**
 *
 * @author GBarbieri
 */
public class VertexAttributeSet {

    private int enableFlags; // bits 0-15 conventional attributes, bits 16-31 generic aliases
    private int normalizeEnableFlags; // only for generic attributes
    private HashMap<Integer, VertexAttribute> vattribs = new HashMap<>();

    public void setVertices(Vec3[] vertices, int count) {
        setVertices(vertices, count, true);
    }

    public void setNormals(Vec3[] normals, int count) {
        setNormals(normals, count, true);
    }

    public void setTexCoords(int unit, Vec2[] coords, int count) {
        setTexCoords(unit, coords, count, true);
    }

    public void setVertices(Vec3[] vertices, int count, boolean enable) {
        setVertexData(VertexAttributeId.POSITION, 3, DataType.FLOAT_32, vertices, 0, count, enable);
    }

    public void setNormals(Vec3[] normals, int count, boolean enable) {
        setVertexData(VertexAttributeId.NORMAL, 3, DataType.FLOAT_32, normals, 0, count, enable);
    }

    public void setTexCoords(int unit, Vec2[] coords, int count, boolean enable) {
        assert (unit < 8);
        VertexAttributeId attrib = VertexAttributeId.values()[VertexAttributeId.TEXCOORD0.value + unit];
        setVertexData(attrib, 3, DataType.FLOAT_32, coords, 0, count, enable);
    }

    public void setVertexData(VertexAttributeId attrib, int size, DataType type, Vec3[] data, int stride,
            int count, boolean enable) {

        assert ((VertexAttributeId.POSITION.value <= attrib.value) && (attrib.value <= VertexAttributeId.ATTR15.value));
        assert ((DataType.INT_8.value <= type.value) && (type.value <= DataType.NUM_DATATYPES.value));
        assert (data != null);

        /**
         * we alias generic and conventional vertex attributes, that is pairs of
         * generic and conventional vertex attributes are sharing the same storage.
         */
        VertexAttributeId attrIndex = attribIndex(attrib);

        VertexAttribute it;

//        if (vattribs.containsKey(attrIndex.value)) {
        /**
         * TODO, append data to existing vertexAttribute.
         */
//        } else {
        it = new VertexAttribute();
//        }
        it.setData(size, type, data, stride, count);
        setEnabled(attrib.value, enable);
    }

    public void setVertexData(VertexAttributeId attrib, int size, DataType type, Buffer data, int stride,
            int count, boolean enable) {

        
    }

    private void setEnabled(int attrib, boolean enable) {
        assert (attrib >= VertexAttributeId.POSITION.value && attrib <= VertexAttributeId.ATTR15.value);

        enableFlags &= ~(1 << attrib);
        enableFlags |= ((enable ? 1 : 0) << attrib);
    }

    private VertexAttributeId attribIndex(VertexAttributeId attrib) {
        if (genericAttrib(attrib)) {
            return VertexAttributeId.values()[attrib.value - VertexAttributeId.ATTR0.value];
        }
        return attrib;
    }

    private boolean genericAttrib(VertexAttributeId attrib) {
        return attrib.value >= VertexAttributeId.ATTR0.value;
    }
}
