/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.jogamp.opengl.util.GLBuffers;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import jglm.Vec3;

/**
 *
 * @author GBarbieri
 */
public class VertexAttribute {

    private int count;  // # vertex data
    private int size;   // # coordinates per vertex 
    private DataType type;   // symbolic constant indicating the type of coordinates
    private int bytes;  // size of vertex in bytes
    private int offset;
    private int strideInBytes; // stride in bytes between two elements in the buffer
    private ByteBuffer buffer;

    public VertexAttribute() {
        type = DataType.UNKNOWN;
    }

    public void setData(int size, DataType type, Vec3[] data, int stride, int count) {

        FloatBuffer dataBuffer = FloatBuffer.allocate(data.length * 3);
        for (Vec3 v : data) {
            dataBuffer.put(v.toFloatArray());
        }
        dataBuffer.rewind();
        
        setData(size, type, dataBuffer, stride, count);
    }

    public void setData(int size, DataType type, Buffer data, int stride, int count) {

        assert (size <= 4);
        assert ((DataType.INT_8.value <= type.value) && (type.value <= DataType.NUM_DATATYPES.value));
        assert (data != null);

        initData(size, type);
        strideInBytes = bytes;

        if (buffer == null) {
            buffer = (ByteBuffer) data;
        }
    }

    private void initData(int size, DataType type) {

        this.size = size;
        this.type = type;
        this.bytes = size * type.getSize();
    }
}
