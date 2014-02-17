
package com.sciaps.libz;

import android.util.Log;
import android.content.Context;
import android.os.ILIBZService;

public class LIBZHardwareManager {

	private static final String LOG_TAG = "LIBZManager";

	private long mNativePtr;

	public LIBZHardwareManager() {
		native_init();
	}

	protected void finalize() {
		native_finalize();
	}

	private native void native_init();
	private native void native_finalize();
}