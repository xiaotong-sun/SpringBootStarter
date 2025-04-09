#include <string.h>
#include "jvmti.h"
#include <iostream>

using namespace std;

static jvmtiEnv *gb_jvmti = NULL;
static jvmtiCapabilities gb_capa;
static jrawMonitorID gb_lock;
static jvmtiError error;

static void JNICALL callbackMethodEntry(jvmtiEnv *jvmti_env, JNIEnv *env, jthread thr, jmethodID method) {
// 获得方法对应的类
jclass clazz;
jvmti_env->GetMethodDeclaringClass(method, &clazz);

// 获得类的签名
char *class_signature;
jvmti_env->GetClassSignature(clazz, &class_signature, nullptr);

//过滤非本工程类信息
string::size_type idx;
string class_signature_str = class_signature;
idx = class_signature_str.find("org/itstack");

gb_jvmti->RawMonitorEnter(gb_lock);

{
//must be deallocate
char *name = NULL, *sig = NULL, *gsig = NULL;
jint thr_hash_code = 0;

error = gb_jvmti->GetMethodName(method, &name, &sig, &gsig);
error = gb_jvmti->GetObjectHashCode(thr, &thr_hash_code);

if (strcmp(name, "start") == 0 || strcmp(name, "interrupt") == 0 ||
strcmp(name, "join") == 0 || strcmp(name, "stop") == 0 ||
strcmp(name, "suspend") == 0 || strcmp(name, "resume") == 0) {

//must be deallocate
jobject thd_ptr = NULL;
jint hash_code = 0;
gb_jvmti->GetLocalObject(thr, 0, 0, &thd_ptr);
gb_jvmti->GetObjectHashCode(thd_ptr, &hash_code);

printf("[线程监控]: thread (%10d) %10s (%10d)\n", thr_hash_code, name, hash_code);
}
}

gb_jvmti->RawMonitorExit(gb_lock);
}

JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *jvm, char *options, void *reserved) {

    // 初始化
    jvm->GetEnv((void **) &gb_jvmti, JVMTI_VERSION_1_0);
    // 创建一个新的环境
    memset(&gb_capa, 0, sizeof(jvmtiCapabilities));
    gb_capa.can_signal_thread = 1;
    gb_capa.can_get_owned_monitor_info = 1;
    gb_capa.can_generate_method_exit_events = 1;
    gb_capa.can_generate_method_entry_events = 1;
    gb_capa.can_generate_exception_events = 1;
    gb_capa.can_generate_vm_object_alloc_events = 1;
    gb_capa.can_tag_objects = 1;
    gb_capa.can_generate_all_class_hook_events = 1;
    gb_capa.can_generate_native_method_bind_events = 1;
    gb_capa.can_access_local_variables = 1;
    gb_capa.can_get_monitor_info = 1;
    // 设置当前环境
    gb_jvmti->AddCapabilities(&gb_capa);
    // 创建一个新的回调函数
    jvmtiEventCallbacks callbacks;
    memset(&callbacks, 0, sizeof(jvmtiEventCallbacks));
    // 方法回调
    callbacks.MethodEntry = &callbackMethodEntry;
    // 设置回调函数
    gb_jvmti->SetEventCallbacks(&callbacks, sizeof(callbacks));

    gb_jvmti->CreateRawMonitor("XFG", &gb_lock);

    // 注册事件监听(JVMTI_EVENT_VM_INIT、JVMTI_EVENT_EXCEPTION、JVMTI_EVENT_NATIVE_METHOD_BIND、JVMTI_EVENT_CLASS_FILE_LOAD_HOOK、JVMTI_EVENT_METHOD_ENTRY、JVMTI_EVENT_METHOD_EXIT)
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_VM_INIT, (jthread) NULL);
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_EXCEPTION, (jthread) NULL);
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_NATIVE_METHOD_BIND, (jthread) NULL);
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_CLASS_FILE_LOAD_HOOK, (jthread) NULL);
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_METHOD_ENTRY, (jthread) NULL);
    error = gb_jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_METHOD_EXIT, (jthread) NULL);

    return JNI_OK;
}