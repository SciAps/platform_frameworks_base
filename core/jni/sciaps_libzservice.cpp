
static void native_init(JNIEnv* env, jobject mgrObject)
{
	sp<ILIBZService> libzservice;
	env->SetLongField(mgrObject, gManagerObject.mNativePtr, reinterpret_cast<jlong>());
}


static JNINativeMethod method_table[] = {
	{ "native_init", "()V", (void*)native_init },
};

int register_sciaps_libzservice(JNIEnv* env) {
	int err = AndroidRuntime::registerNativeMethods(env, "com/sciaps/libz/LIBZHardwareManager",
            method_table, NELEM(method_table));

	return err;
}