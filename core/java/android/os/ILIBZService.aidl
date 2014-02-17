
package android.os;

import android.os.IFPGACallback;

interface ILIBZService {
	
	float getArgonPressure();


	int readFPGARegister(int index);
	void writeFPGARegister(int index, int value);
	void registerFPGACallback(in IFPGACallback cb);
	void unregisterFPGACallback(in IFPGACallback cb);
	void go();
	void halt();



}