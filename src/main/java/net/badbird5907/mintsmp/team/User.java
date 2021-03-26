package net.badbird5907.mintsmp.team;

import net.badbird5907.mintsmp.chat.ChatChannel;

import java.util.UUID;

public class User {
    public UUID uuid;
    public Role role = Role.MEMBER;
    public ChatChannel channel = ChatChannel.ALL;
    public Team team = null;
    public User(UUID uuid){
        this.uuid = uuid;
    }
}
