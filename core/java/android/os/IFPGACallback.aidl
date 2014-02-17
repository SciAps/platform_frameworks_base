
package android.os;

import android.os.FPGADataBuffer;

interface IFPGACallback {
	
	oneway void onDataReady(in FPGADataBuffer data);

}