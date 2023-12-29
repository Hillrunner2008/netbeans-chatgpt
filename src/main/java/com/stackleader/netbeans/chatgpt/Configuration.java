package com.stackleader.netbeans.chatgpt;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

public class Configuration {

    public static final String OPENAI_TOKEN_KEY = "OPENAI_TOKEN";

    private final Preferences preferences = NbPreferences.forModule(ChatTopComponent.class);

    public static Configuration getInstance() {
        return OptionsHolder.INSTANCE;
    }

    private Configuration() {
    }

    public Preferences getPreferences() {
        return preferences;
    }

    private static class OptionsHolder {

        private static final Configuration INSTANCE = new Configuration();
    }
}
