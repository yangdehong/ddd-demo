package com.ydh.redsheep.core.messaging;

import com.ydh.redsheep.core.domain.types.AuditMessage;

public interface AuditMessageProducer {
    void send(AuditMessage message);
}
