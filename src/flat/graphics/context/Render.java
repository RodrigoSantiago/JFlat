package flat.graphics.context;

import flat.backend.GL;
import flat.graphics.context.enuns.PixelFormat;
import flat.screen.Application;

public class Render extends ContextObject {

    private int renderBufferId;
    private PixelFormat format;

    private int width, height;

    public Render() {
        init();
    }

    @Override
    protected void onInitialize() {
        this.renderBufferId = GL.RenderBufferCreate();
    }

    @Override
    protected void onDispose() {
        GL.RenderBufferDestroy(renderBufferId);
    }

    int getInternalID() {
        return renderBufferId;
    }

    public void begin() {
        Application.getCurrentContext().bindRender(this);
    }

    public void end() {
        Application.getCurrentContext().unbindRender();
    }

    public void setData(PixelFormat format, int width, int height) {
        this.format = format;
        this.width = width;
        this.height = height;
        GL.RenderBufferStorage(format.getInternalEnum(), width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PixelFormat getFormat() {
        return format;
    }
}
