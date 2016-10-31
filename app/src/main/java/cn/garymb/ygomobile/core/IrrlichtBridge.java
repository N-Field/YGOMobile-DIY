/*
 * IrrlichtBridge.java
 *
 *  Created on: 2014年3月18日
 *      Author: mabin
 */
package cn.garymb.ygomobile.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author mabin
 */
public final class IrrlichtBridge {
    static {
        System.loadLibrary("YGOMobile");
    }

    public interface IrrlichtApplication {
        String getCardImagePath();

        void setLastDeck(String name);

        String getFontPath();

        String getLastDeck();

        float getScreenWidth();

        float getScreenHeight();

        void playSoundEffect(String path);
    }

    public interface IrrlichtHost {
        void toggleOverlayView(boolean isShow);

        ByteBuffer getInitOptions();

        ByteBuffer getNativeInitOptions();

        void toggleIME(String hint, boolean isShow);

        void showComboBoxCompat(String[] items, boolean isShow, int mode);

        void performHapticFeedback();

        /** 签名 */
        byte[] performTrick();

        int getLocalAddress();

        void setNativeHandle(int nativeHandle);
    }

    public static int sNativeHandle;

    private static native byte[] nativeBpgImage(byte[] data);

    private static native void nativeInsertText(int handle, String text);

    private static native void nativeRefreshTexture(int handle);

    private static native void nativeIgnoreChain(int handle, boolean begin);

    private static native void nativeReactChain(int handle, boolean begin);

    private static native void nativeCancelChain(int handle);

    private static native void nativeSetCheckBoxesSelection(int handle, int idx);

    private static native void nativeSetComboBoxSelection(int handle, int idx);

    private static native void nativeJoinGame(int handle, ByteBuffer buffer, int length);

    public static native String getAccessKey();

    public static native String getSecretKey();

    public static void cancelChain() {
        nativeCancelChain(sNativeHandle);
    }

    public static void ignoreChain(boolean begin) {
        nativeIgnoreChain(sNativeHandle, begin);
    }

    public static void reactChain(boolean begin) {
        nativeReactChain(sNativeHandle, begin);
    }

    public static void insertText(String text) {
        nativeInsertText(sNativeHandle, text);
    }

    public static Bitmap getBpgImage(byte[] bpg, int width, int height) {
        byte[] data = nativeBpgImage(bpg);
//        Log.i("kk", "zip image:"+(bpg==null?-1:bpg.length)+"/"+(data==null?-1:data.length));
        int[] colors = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            colors[i] = data[i];
        }
        return Bitmap.createBitmap(colors, width, height, Bitmap.Config.RGB_565);
    }

    public static void setComboBoxSelection(int idx) {
        nativeSetComboBoxSelection(sNativeHandle, idx);
    }

    public static void refreshTexture() {
        nativeRefreshTexture(sNativeHandle);
    }

    public static void setCheckBoxesSelection(int idx) {
        nativeSetCheckBoxesSelection(sNativeHandle, idx);
    }

    public static void joinGame(ByteBuffer buffer, int length) {
        nativeJoinGame(sNativeHandle, buffer, length);
    }
}
