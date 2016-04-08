package xyz.ruoxue.opengl.entities.game;

import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import xyz.ruoxue.opengl.entities.BasicEntities;
import xyz.ruoxue.opengl.ui.customview.MyTdView;

/**
 * Created by RuoxueYe on 2016/4/7.
 */
public class Triangle extends BasicEntities {

    public  static  float[] mProjMatrix=new float[16];
    public  static  float[] mvMarix=new float[16];
    public  static  float[] mmvpMatrix;
    int mProgram;

    int muMvpMatrixHandle;
    int maPositionHandle;
    int macoloHandle;
    String mVertexShader;
    String mFragmentShader;
    static  float[] mMMstatrix=new float[16];

    FloatBuffer mVerexBuffer;
    FloatBuffer mColorBuffer;
    int vCount;
    float xAngle=0;

    public  Triangle(MyTdView mv){
        initVertexData();
        initShader(mv);
    }

    public void initShader(MyTdView mv) {

    }

    public void initVertexData() {

        vCount=3;
        final  float UNIT_SIZE=0.2f;
        float vertices[]=new float[]{
                -4*UNIT_SIZE,0,0,0,-4*UNIT_SIZE,0,4*UNIT_SIZE,0,0

        };


        ByteBuffer vbb=ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        mVerexBuffer=vbb.asFloatBuffer();

        mVerexBuffer.put(vertices);
        mVerexBuffer.position(0);


        float colors[]=new float[]{
                1,1,10,0,0,1,0,0,1,0,0,
        };



        ByteBuffer cbb=ByteBuffer.allocateDirect(colors.length*4);

        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer=cbb.asFloatBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);






    }


    public static  float[] getFinalMatrix(float[] spec){

        mmvpMatrix=new float[16];
        Matrix.multiplyMM(mmvpMatrix,0,mvMarix,0,spec,0);
        Matrix.multiplyMM(mmvpMatrix,0,mProjMatrix,0,mmvpMatrix,0);

        return  mmvpMatrix;


    }


}
