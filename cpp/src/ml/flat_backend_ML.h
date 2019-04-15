/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class flat_backend_ML */

#ifndef _Included_flat_backend_ML
#define _Included_flat_backend_ML
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     flat_backend_ML
 * Method:    mul
 * Signature: ([F[F)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_mul
  (JNIEnv *, jclass, jfloatArray, jfloatArray);

/*
 * Class:     flat_backend_ML
 * Method:    mulVec
 * Signature: ([F[F)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_mulVec___3F_3F
  (JNIEnv *, jclass, jfloatArray, jfloatArray);

/*
 * Class:     flat_backend_ML
 * Method:    mulVec
 * Signature: ([F[FIII)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_mulVec___3F_3FIII
  (JNIEnv *, jclass, jfloatArray, jfloatArray, jint, jint, jint);

/*
 * Class:     flat_backend_ML
 * Method:    prj
 * Signature: ([F[F)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_prj___3F_3F
  (JNIEnv *, jclass, jfloatArray, jfloatArray);

/*
 * Class:     flat_backend_ML
 * Method:    prj
 * Signature: ([F[FIII)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_prj___3F_3FIII
  (JNIEnv *, jclass, jfloatArray, jfloatArray, jint, jint, jint);

/*
 * Class:     flat_backend_ML
 * Method:    rot
 * Signature: ([F[F)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_rot___3F_3F
  (JNIEnv *, jclass, jfloatArray, jfloatArray);

/*
 * Class:     flat_backend_ML
 * Method:    rot
 * Signature: ([F[FIII)V
 */
JNIEXPORT void JNICALL Java_flat_backend_ML_rot___3F_3FIII
  (JNIEnv *, jclass, jfloatArray, jfloatArray, jint, jint, jint);

/*
 * Class:     flat_backend_ML
 * Method:    inv
 * Signature: ([F)Z
 */
JNIEXPORT jboolean JNICALL Java_flat_backend_ML_inv
  (JNIEnv *, jclass, jfloatArray);

/*
 * Class:     flat_backend_ML
 * Method:    det
 * Signature: ([F)F
 */
JNIEXPORT jfloat JNICALL Java_flat_backend_ML_det
  (JNIEnv *, jclass, jfloatArray);

#ifdef __cplusplus
}
#endif
#endif
