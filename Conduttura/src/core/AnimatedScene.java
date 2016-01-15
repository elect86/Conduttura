/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import components.Group;
import components.Scene;
import jglm.Vec2;
import jglm.Vec2i;

/**
 *
 * @author GBarbieri
 */
public class AnimatedScene {

    private Vec2 gridSize;
    private Vec2i objectCount;
    private Group root;
    private Scene scene;

    public AnimatedScene(Vec2 gridSize, Vec2i objectCount) {
        
        this.gridSize = gridSize;
        this.objectCount = objectCount;
        
        root = new Group();
        scene = new Scene();
        scene.setRoot(root);
    }
}
