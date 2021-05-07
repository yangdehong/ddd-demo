package com.ydh.redsheep.domain.messaging;

import com.ydh.redsheep.domain.domain.types.AuditMessage;

public interface AuditMessageProducer {
    void send(AuditMessage message);
}
