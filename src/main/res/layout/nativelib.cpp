//
// Created by flori on 07/03/2021.
//

#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_touhidapps_MyProject_utils_MyConstants_baseUrlFromJNI(JNIEnv *env, jobject) {
    std::string mUrl = "aHR0cDovL2FwaS5leGFtcGxlLmNvbS8=";
    return env->NewStringUTF(mUrl.c_str());
}