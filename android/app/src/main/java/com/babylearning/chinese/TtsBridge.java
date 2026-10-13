package com.babylearning.chinese;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.webkit.JavascriptInterface;

import java.util.Locale;

/**
 * 暴露给网页的 window.AndroidTTS。WebView 里没有 speechSynthesis 的中文语音，
 * 游戏检测到这个对象后改用系统朗读引擎。
 */
public class TtsBridge {

    private final TextToSpeech tts;
    private volatile boolean ready = false;
    private float rate = 0.8f;
    private int seq = 0;

    TtsBridge(Context ctx) {
        tts = new TextToSpeech(ctx.getApplicationContext(),
                status -> ready = status == TextToSpeech.SUCCESS);
    }

    private static Locale locale(String lang) {
        return "fi".equals(lang) ? new Locale("fi", "FI") : Locale.SIMPLIFIED_CHINESE;
    }

    @JavascriptInterface
    public boolean hasLang(String lang) {
        if (!ready) return "zh".equals(lang);   // 还在初始化时先乐观地认为中文可用
        int r = tts.isLanguageAvailable(locale(lang));
        return r >= TextToSpeech.LANG_AVAILABLE;
    }

    @JavascriptInterface
    public void rate(float r) {
        rate = r;
    }

    /** 小青蛙过河、骑车闯关使用：用当前语速读中文。 */
    @JavascriptInterface
    public boolean speak(String text) {
        return speakLang(text, "zh", rate, true);
    }

    @JavascriptInterface
    public synchronized boolean speakLang(String text, String lang, float r, boolean flush) {
        if (!ready || text == null || text.isEmpty() || !hasLang(lang)) return false;
        tts.setLanguage(locale(lang));
        tts.setSpeechRate(r);
        tts.setPitch(1.08f);
        int res = tts.speak(text, flush ? TextToSpeech.QUEUE_FLUSH : TextToSpeech.QUEUE_ADD,
                null, "u" + (seq++));
        return res == TextToSpeech.SUCCESS;
    }

    @JavascriptInterface
    public void stop() {
        if (ready) tts.stop();
    }

    void shutdown() {
        tts.shutdown();
    }
}
