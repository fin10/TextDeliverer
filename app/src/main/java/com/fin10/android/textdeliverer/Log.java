package com.fin10.android.textdeliverer;

public class Log {

    private static Log sInstance;

    private final String mTag;

    private Log(String tag) {
        mTag = tag;
    }

    public static void init(String tag) {
        synchronized (Log.class) {
            if (sInstance == null) {
                sInstance = new Log(tag);
            }
        }

        Log.d("tag:%s", sInstance.mTag);
    }

    public static void d(String format, Object... args) {
        try {
            android.util.Log.d(sInstance.mTag, sInstance.buildMsg(String.format(format, args)));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void e(String format, Object... args) {
        try {
            android.util.Log.e(sInstance.mTag, sInstance.buildMsg(String.format(format, args)));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private String buildMsg(String msg) {
        StackTraceElement element = Thread.currentThread().getStackTrace()[4];
        StringBuilder buf = new StringBuilder(80);
        String fName = element.getFileName();
        if (fName == null) {
            buf.append("(Unknown Source)");
        } else {
            int lineNum = element.getLineNumber();

            buf.append('(');
            buf.append(fName);
            if (lineNum >= 0) {
                buf.append(':');
                buf.append(lineNum);
            }
            buf.append(')');
        }

        buf.append(' ');
        buf.append(msg);

        return buf.toString();
    }
}
