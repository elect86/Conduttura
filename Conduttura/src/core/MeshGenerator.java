/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import components.Primitive;
import components.VertexAttributeSet;
import jglm.Vec2;
import jglm.Vec3;

/**
 *
 * @author GBarbieri
 */
public class MeshGenerator {

    public static Primitive createSphere(int m, int n, float radius) {

        if (!(m >= 3 && n >= 3)) {
            throw new Error("MeshGenerator.createSphere(): m and n both have to be at least 3.");
        }

        // setup vertices, normals, indices/faces and texture coordinates
        Vec3[] vertices;
        Vec3[] tangents;
        Vec3[] binormals;
        Vec3[] normals;
        Vec2[] texCoords;
        int[] indices;

        int size = (m + 1) * n;
        vertices = new Vec3[size];
        tangents = new Vec3[size];
        binormals = new Vec3[size];
        normals = new Vec3[size];
        texCoords = new Vec2[size];
        indices = new int[6 * m * (n - 1)];

        float phiStep = (float) (2.0f * Math.PI / m);
        float thetaStep = (float) (Math.PI / (n - 1));

        // Latitudinal rings.
        // Starting at the south pole going upwards.
        for (int latitude = 0; latitude < n; latitude++) // theta angle
        {
            float theta = latitude * thetaStep;
            float sinTheta = (float) Math.sin(theta);
            float cosTheta = (float) Math.cos(theta);
            float texv = latitude / (float) (n - 1); // Range [0.0f, 1.0f]

            // Generate vertices along the latitudinal rings.
            // On each latitude there are m + 1 vertices,
            // the last one and the first one are on identical positions but have different texture coordinates.
            for (int longitude = 0; longitude <= m; longitude++) // phi angle
            {
                float phi = longitude * phiStep;
                float sinPhi = (float) Math.sin(phi);
                float cosPhi = (float) Math.cos(phi);
                float texu = longitude / (float) m; // Range [0.0f, 1.0f]

                // Unit sphere coordinates are the normals.
                Vec3 v = new Vec3(cosPhi * sinTheta,
                        -cosTheta, // -y to start at the south pole.
                        -sinPhi * sinTheta);

                vertices[latitude * m + longitude] = v.times(radius);
                texCoords[latitude * m + longitude] = new Vec2(texu, texv);
                normals[latitude * m + longitude] = new Vec3(v);
                tangents[latitude * m + longitude] = new Vec3(-sinPhi, 0.0f, -cosPhi);
                binormals[latitude * m + longitude] = new Vec3(cosTheta * cosPhi, sinTheta, cosTheta * -sinPhi);
            }
        }

        // We have generated m + 1 vertices per latitude.
        int columns = m + 1;

        // Calculate indices
        for (int latitude = 0; latitude < n - 1; latitude++) {
            
            for (int longitude = 0; longitude < m; longitude++) {
                
                indices[latitude * m + longitude] = latitude * columns + longitude;  // lower left
                indices[latitude * m + longitude] = latitude * columns + longitude + 1;  // lower right
                indices[latitude * m + longitude] = (latitude + 1) * columns + longitude + 1;  // upper right

                indices[latitude * m + longitude] = (latitude + 1) * columns + longitude + 1;  // upper right
                indices[latitude * m + longitude] = (latitude + 1) * columns + longitude;  // upper left
                indices[latitude * m + longitude] = latitude * columns + longitude;  // lower left
            }
        }
        
        // Create a VertexAttributeSet with vertices, normals and texcoords
        VertexAttributeSet vas = new VertexAttributeSet();
        vas.

        return null;
    }
}
