package com.example.hzzhoulong.materialdesingcomponents.Behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author hzzhoulong
 * @date 2016/5/26.
 */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    public static final String TAG = "ZhouLong";
    public ScrollAwareFABBehavior(Context context, AttributeSet set) {
        super();
        Log.d(TAG, "init");
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.d(TAG, "onStartNestedScroll");
        return nestedScrollAxes== ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout,child,directTargetChild,target,nestedScrollAxes);
    }

//    @Override
//    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target) {
//        super.onStopNestedScroll(coordinatorLayout, child, target);
//        Log.d(TAG, "onStopNestedScroll"+target.toString());
//        child.show();
//    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.d(TAG, dyConsumed + " ");

        Log.d(TAG, target.toString());
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            Log.d(TAG, "hide");
            child.hide();
        }
        else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            Log.d(TAG, "show");
            child.show();
        }
        Log.d(TAG, "onNestedScroll");
    }
}
