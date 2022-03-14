package com.golovanova.dto;

import com.golovanova.CommandType;

import java.io.Serializable;

public interface CommandMessage extends Serializable {
    CommandType getCommandType();
}
