
#define LOG_TAG "LIBZService_jni"
#include <utils/Log.h>

#include <hardware/hardware.h>
#include <hardware/libzhw.h>

#include "jni.h"
#include "JNIHelp.h"
#include "android_runtime/AndroidRuntime.h"

namespace android
{

static jlong init_native(JNIEnv *env, jobject clazz)
{

	ALOGD("in init_native");

	int err;
	hw_module_t* module;
	libzhw_device_t* dev = NULL;

	if(hw_get_module(SCIAPS_LIBZHW_MODULE_ID, (hw_module_t const**)&module) == 0){
		ALOGD("got libz module");
		if(module->methods->open(module, SCIAPS_LIBZHW_MODULE_ID, ((hw_device_t**) &dev)) != 0){
			ALOGE("could not open hardware module");
			return 0;
		}
	} else {
		ALOGE("could not get hardware module");
		return 0;
	}

	ALOGD("init_native success");

	return (jlong)dev;
}

static void finalize_native(JNIEnv *env, jobject clazz, jlong ptr)
{
	libzhw_device_t* dev = (libzhw_device_t*)ptr;
	if(dev != NULL) {
		free(dev);
	}
}

static jfloat read_pressure(JNIEnv* env, jobject clazz, jlong ptr)
{

	ALOGD("starting read_pressure dev: 0x%x", ptr);

	int rawvalue;
	int num_bytes_read;

	libzhw_device_t* dev = (libzhw_device_t*)ptr;
	if(dev == NULL) {
		ALOGE("native pointer is NULL");
		return 0;
	}

	ALOGD("read pressure function: 0x%x", dev->read_pressure);

	uint8_t buf[4];
	num_bytes_read = dev->read_pressure(buf, 4);
	if(num_bytes_read >= 2){
		rawvalue = (buf[0] << 8) | buf[1];
		return ((rawvalue - 0x0666)*(15-0)) / ((float)(0x399A-0x0666)) + 0;
	} else {
		ALOGE("unable to read pressure: %d", num_bytes_read);
	}


	return 0;
}

static JNINativeMethod method_table[] = {
	{ "init_native", "()J", (void*)init_native },
	{ "finalize_native", "(J)V", (void*)finalize_native },
	{ "read_pressure", "(J)F", (void*)read_pressure }
};

int register_android_server_LIBZService(JNIEnv* env)
{
	return jniRegisterNativeMethods(env, "com/android/server/LIBZService",
            method_table, NELEM(method_table));
}

};