package flat.widget.value;

import flat.animations.StateInfo;
import flat.backend.GL;
import flat.events.HoverEvent;
import flat.events.PointerEvent;
import flat.graphics.SmartContext;
import flat.math.Mathf;
import flat.math.Vector2;
import flat.math.shapes.Arc;
import flat.math.shapes.Shape;
import flat.math.stroke.BasicStroke;
import flat.uxml.Controller;
import flat.uxml.UXStyle;
import flat.uxml.UXStyleAttrs;
import flat.widget.Application;
import flat.widget.Widget;

public class ProgressCircle extends Widget {

    private float progress;
    private int color;
    private float indicatorSize;
    private float animationDuration;
    private float anim;
    private long time;
    private Arc arc = new Arc(Arc.Type.OPEN);

    @Override
    public void applyAttributes(UXStyleAttrs style, Controller controller) {
        super.applyAttributes(style, controller);

        setProgress(style.asNumber("progress", getProgress()));
        setAnimationDuration(style.asNumber("animation-duration", getAnimationDuration()));
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        UXStyle style = getStyle();
        if (style == null) return;

        StateInfo info = getStateInfo();

        setColor(style.asColor("color", info, getColor()));
        setIndicatorSize(style.asSize("indicator-size", info, getIndicatorSize()));
    }

    @Override
    public void onDraw(SmartContext context) {
        backgroundDraw(0, getBorderColor(), getRippleColor(), context);

        context.setTransform2D(getTransform());
        float x = getInX();
        float y = getInY();
        float w = getInWidth();
        float h = getInHeight();

        context.setStroker(new BasicStroke(4f));
        context.setColor(getBackgroundColor());
        context.drawEllipse(x + 2, y + 2, w - 4, h - 4, false);

        context.setColor(color);
        if (progress >= 0) {
            arc.set(x + 2, y + 2, w - 4, h - 4, 90, 0, Arc.Type.OPEN);
            context.drawShape(arc, false);
        } else if (animationDuration > 0) {
            long t = System.currentTimeMillis();
            long pass = t - time;
            time = t;

            anim += pass / Math.abs(animationDuration);
            anim = Mathf.clamp(anim, 0, 1);
            float p = anim;
            float p0 = p < 0.125f ? p * 6 :
                    p < 0.250f ? 0.75f :
                            p < 0.375f ? (p - 0.125f) * 6 :
                                    p < 0.500f ? 1.5f :
                                            p < 0.625f ? (p - 0.250f) * 6 :
                                                    p < 0.750f ? 2.25f :
                                                            p < 0.875f ? (p - 0.375f) * 6 : 3.00f;
            float p1 = p < 0.125f ? 0 :
                    p < 0.250f ? (p - 0.125f) * 6 :
                            p < 0.375f ? 0.75f :
                                    p < 0.500f ? (p - 0.250f) * 6 :
                                            p < 0.625f ? 1.5f :
                                                    p < 0.750f ? (p - 0.375f) * 6 :
                                                            p < 0.875f ? 2.25f : (p - 0.500f) * 6;

            arc.set(x + 2, y + 2, w - 4, h - 4, -((anim * 3240) + (p1 * 360)), ((p1 - p0) * 360), Arc.Type.OPEN);
            context.drawShape(arc, false);

            if (anim == 1) {
                anim = 0;
            }

            invalidate(false);
        }
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        if (progress < 0) progress = -1;
        if (progress > 1) progress = 1;

        if (this.progress != progress) {
            this.progress = progress;
            if (progress == -1) {
                time = System.currentTimeMillis();
            }
            anim = 0;
            invalidate(false);
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        if (this.color != color) {
            this.color = color;
            invalidate(false);
        }
    }

    public float getIndicatorSize() {
        return indicatorSize;
    }

    public void setIndicatorSize(float indicatorSize) {
        if (this.indicatorSize != indicatorSize) {
            this.indicatorSize = indicatorSize;
            invalidate(false);
        }
    }

    public float getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(float milis) {
        if (this.animationDuration != milis) {
            this.animationDuration = milis;
        }
    }
}
