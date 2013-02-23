LOCAL_PATH:= $(call my-dir)

# the library
# ============================================================
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-java-files-under, src)
            
ifeq ($(OMAP_ENHANCEMENT), true)
LOCAL_JAVA_LIBRARIES += services
endif

LOCAL_MODULE := android.policy

include $(BUILD_JAVA_LIBRARY)

# additionally, build unit tests in a separate .apk
include $(call all-makefiles-under,$(LOCAL_PATH))
