package com.flywolf.li.sales.channel.controller;

import com.flywolf.li.framework.dto.Page;
import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.sales.channel.dto.req.QueryChannelRequest;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelRequest;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import com.flywolf.li.sales.channel.dto.resp.QueryChannelResponse;
import com.flywolf.li.sales.channel.service.ChannelService;
import com.flywolf.li.sales.channel.service.bo.ChannelBO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.mockito.Mockito.*;


class ChannelControllerTest {
    @Mock
    ChannelService service;
    @Mock
    Logger log;
    @InjectMocks
    ChannelController channelController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testRegister() {
        when(service.register(any())).thenReturn(Long.valueOf(1));
        Result<Long> result = channelController.register(new RegisterChannelRequest());
        Assertions.assertEquals(new Result<Long>("00000", "success", Long.valueOf(1)), result);
    }

    @Test
    void testUpdate() {
        Result result = channelController.update(new RegisterChannelRequest());
        Assertions.assertEquals(new Result("00000", "success", null), result);
    }

    @Test
    void testGet() {
        when(service.get(anyLong())).thenReturn(new ChannelBO());

        Result<QueryChannelResponse> result = channelController.get(Long.valueOf(1));
        //Assertions.assertEquals(new Result<QueryChannelResponse>("code", "msg", new QueryChannelResponse()), result);
    }

    @Test
    void testQuery() {
        when(service.query(any())).thenReturn(Arrays.<ChannelBO>asList(new ChannelBO()));

        Result<Page<QueryChannelResponse>> result = channelController.query(new QueryChannelRequest());
        //Assertions.assertEquals(new Result<Page<QueryChannelResponse>>("code", "msg", new Page<QueryChannelResponse>(0, 0, 0, 0L, Arrays.<QueryChannelResponse>asList(new QueryChannelResponse()))), result);
    }

    @Test
    void testGet2() {
        when(service.findAll()).thenReturn(Arrays.<ChannelBO>asList(new ChannelBO()));

        Result<Page<ChannelResponse>> result = channelController.get();
        //Assertions.assertEquals(new Result<Page<ChannelResponse>>("code", "msg", new Page<ChannelResponse>(0, 0, 0, 0L, Arrays.<ChannelResponse>asList(new ChannelResponse()))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme