package com.flywolf.li.sales.dou.service;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import com.flywolf.li.sales.dou.entity.Dou;
import com.flywolf.li.sales.dou.remote.ChannelRemoteService;
import com.flywolf.li.sales.dou.repository.DouRepository;
import com.flywolf.li.sales.dou.service.bo.DouBO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

class DouServiceImplTest {
    @Mock
    DouRepository douRepository;
    @Mock
    ChannelRemoteService channelRemoteService;
    @Mock
    Logger log;
    @InjectMocks
    DouServiceImpl douServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        Long result = douServiceImpl.register(new DouBO());
        //Assertions.assertEquals(Long.valueOf(1), result);
    }

    @Test
    void testUpdate() {
        douServiceImpl.update(new DouBO());
    }

    @Test
    void testDelete() {
        douServiceImpl.delete(Long.valueOf(1));
    }

    @Test
    void testFindById() {
        Dou dou=new Dou();
        dou.setChannelId(Long.valueOf(1));
        when(douRepository.getById(anyLong())).thenReturn(dou);
        when(channelRemoteService.get(anyLong())).thenReturn(new Result<ChannelResponse>("code", "msg", new ChannelResponse()));

        DouBO result = douServiceImpl.findById(Long.valueOf(1));
        Assertions.assertEquals(new DouBO(), result);
    }

    @Test
    void testFindAll() {
        List<DouBO> result = douServiceImpl.findAll();
        Assertions.assertEquals(Arrays.<DouBO>asList(new DouBO()), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme