package com.application.andrilsutil.view;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * The type View utils.
 *
 * @author Nishant Srivastava
 */
public class ViewUtil {

  private ViewUtil() {
    throw new UnsupportedOperationException(
        "Should not create instance of Util class. Please use as static..");
  }

  /**
   * Get the screen dimensions
   *
   * @param activity the activity
   * @return the int [ ]
   */
  public static int[] getScreenSize(Activity activity) {
    Point size = new Point();
    WindowManager w = activity.getWindowManager();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
      w.getDefaultDisplay().getSize(size);
      return new int[] { size.x, size.y };
    } else {
      Display d = w.getDefaultDisplay();
      //noinspection deprecation
      return new int[] { d.getWidth(), d.getHeight() };
    }
  }

  /**
   * Set orientation change lock
   *
   * @param activity the activity
   * @param status the status
   */
  public static void setOrientation(Activity activity, boolean status) {
    if (status) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
      }
    } else {
      activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
    }
  }

  public static int dpToPx(int dps, Context mContext) {
    final float scale = mContext.getResources().getDisplayMetrics().density;
    return (int) (dps * scale + 0.5f);
  }

  public static void setLayoutSize(View view, int width, int height) {
    ViewGroup.LayoutParams params = view.getLayoutParams();
    params.width = width;
    params.height = height;
    view.setLayoutParams(params);
  }

  private static void setLayoutSizeAndGravity(View view, int width, int height, int gravity) {
    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
    params.width = width;
    params.height = height;
    params.gravity = gravity;
    view.setLayoutParams(params);
  }

  /**
   * Hide On Screen Keyboard for EditText
   *
   * @param activity the activity
   * @param editText the edit text
   */
  public static void hideOnScreenKeyboardForEditText(Activity activity, EditText editText) {
    ((InputMethodManager) activity.getSystemService(
        Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText.getWindowToken(), 0);
  }
}
