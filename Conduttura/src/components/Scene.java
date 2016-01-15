/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import jglm.Vec3;
import jglm.Vec4;

/**
 *
 * @author GBarbieri
 */
public class Scene {

    private Vec3 ambientColor;
    private Vec4 backColor;
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

}
