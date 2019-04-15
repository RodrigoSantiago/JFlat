//
// Created by Rodrigo on 25/10/2018.
//

#ifndef FLATVECTORS_RENDER_H
#define FLATVECTORS_RENDER_H

#include <flatvectors.h>

void* renderCreate();

void renderAlloc(void* data, int paint, int element, int vertex);

void renderDestroy(void *data);

void renderBegin(void *data, unsigned int width, unsigned int height);

void renderEnd(void *data);

void renderClearClip(void* data, int clip);

void renderFlush(void *data,
                 fvPaint *paints, int pSize,
                 short* elements, int eSize,
                 float *vtx, float *uvs, int vSize);

unsigned long renderCreateFontTexture(void* data, int width, int height);

void renderUpdateFontTexture(unsigned long imageID, void* data, int x, int y, int width, int height);

void renderDestroyFontTexture(unsigned long imageID);

#endif //FLATVECTORS_RENDER_H