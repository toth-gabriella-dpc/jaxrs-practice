package com.dpc.database;

import com.dpc.model.Message;
import com.dpc.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    public static Map<Long, Message> messages = new HashMap<>();
    public static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
