package com.application.andrilsutil.time;

import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by poepoe on 17/1/15.
 */
public class TimeUtils {

  public final static long ONE_SECOND = 1000;

  public final static long ONE_MINUTE = ONE_SECOND * 60;

  public final static long ONE_HOUR = ONE_MINUTE * 60;

  public final static long ONE_DAY = ONE_HOUR * 24;

  private TimeUtils() {
  }

  public static String millisToLongDHMS(long duration) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date now = new Date();
    CharSequence ago = null;
    if (duration >= ONE_SECOND) {
      ago = DateUtils.getRelativeTimeSpanString(duration, now.getTime(),
          DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);
      return ago.toString();
    } else if (duration > ONE_MINUTE) {
      ago = DateUtils.getRelativeTimeSpanString(duration, now.getTime(),
          DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);
      return ago.toString();
    } else if (duration > ONE_HOUR) {
      ago = DateUtils.getRelativeTimeSpanString(duration, now.getTime(),
          DateUtils.HOUR_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);
      return ago.toString();
    } else if (duration > ONE_DAY) {
      ago = DateUtils.getRelativeTimeSpanString(duration, now.getTime(),
          DateUtils.DAY_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);
      return ago.toString();
    } else {
      ago = "just now";
    }
    return ago.toString();
  }
}


