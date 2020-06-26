package com.hc.events;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.MongoMappingEvent;
import org.springframework.stereotype.Component;

import com.hc.model.User;
import com.hc.security.util.SequenceGeneratorService;


@Component
public class UserModelListener extends AbstractMongoEventListener<User> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    
    public void onBeforeConvert(MongoMappingEvent<?> event) {
		/*
		 * if (event.getSource().getId() < 1) {
		 * event.getSource().setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME
		 * )); }
		 */
    }


}