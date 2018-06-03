#include <jni.h>
#include <string>
//  #include <opencv2/core.hpp>



extern "C"
JNIEXPORT jstring

JNICALL
Java_ca_wogal_opencv_13_10_10_MainActivity_1100_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
