package edu.ib.zpo14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BallView extends View {


    private int viewWidth;
    private int viewHeight;
    Ball ball;

    public BallView(Context context) {
        super(context);
        Paint ballPaint=new Paint();
        ballPaint.setColor(Color.RED);
        ball = new Ball(this,0,0, 50,ballPaint);
    }
    public Ball getBall(){
        return ball;
    }

    public int getViewWidth() {
        return viewWidth;
    }

    public int getViewHeight() {
        return viewHeight;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewWidth = w;
        viewHeight = h;
        ball.setX(viewWidth/2);
        ball.setY(viewHeight/2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ball.calculate();
        canvas.drawCircle((float)ball.getX(), (float) ball.getY(), (float) ball.getRadius(), ball.getPaint());
        invalidate();
    }
}
