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
public enum PixelFormat {

    PF_R,
    PF_RG,
    PF_RGB,
    PF_RGBA,
    PF_BGR,
    PF_BGRA,
    PF_LUMINANCE,
    PF_ALPHA,
    PF_LUMINANCE_ALPHA,
    PF_DEPTH_COMPONENT,
    PF_DEPTH_STENCIL,
    PF_STENCIL_INDEX,
    PF_NATIVE,
    PF_NUM_PIXELFORMATS,
    PF_UNKNOWN;

    public final int value;

    private PixelFormat() {
        value = Counter.nextValue;
        Counter.nextValue++;
    }

    /**
     * Trick to get automatic incremental values.
     */
    private static class Counter {

        private static int nextValue = 0;
    }
}
