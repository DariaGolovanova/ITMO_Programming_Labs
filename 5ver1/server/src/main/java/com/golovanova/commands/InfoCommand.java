package com.golovanova.commands;

import com.golovanova.CommandType;
import com.golovanova.utility.CollectionInfo;

import java.io.Serializable;

public class InfoCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public InfoCommand() {
        super(CommandType.info);
    }

    public String execute(CollectionInfo collectionInfo) {
        String summary = collectionInfo.summary();
        return summary;
    }
}
