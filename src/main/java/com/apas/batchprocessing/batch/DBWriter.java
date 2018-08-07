package com.apas.batchprocessing.batch;


import com.apas.model.User;
import com.apas.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
//        userRepository.findByUsernameAndPassword("test", "test");

        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
