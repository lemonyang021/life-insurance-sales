package com.flywolf.li.sales.channel.controller;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelCategoryRequest;
import com.flywolf.li.sales.channel.dto.req.RegisterChannelRequest;
import com.flywolf.li.sales.channel.service.ChannelCategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

class ChannelCategoryControllerTest {
    @Mock
    ChannelCategoryService channelCategoryService;
    @Mock
    Logger log;
    @InjectMocks
    ChannelCategoryController channelCategoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        when(channelCategoryService.register(any())).thenReturn(Long.valueOf(1));

        Result<Long> result = channelCategoryController.register(new RegisterChannelCategoryRequest());
        Assertions.assertEquals(new Result<Long>("00000", "success", Long.valueOf(1)), result);
    }

    @Test
    void testUpdate() {
        when(channelCategoryService.register(any())).thenReturn(Long.valueOf(1));

        Result<Long> result = channelCategoryController.update(new RegisterChannelRequest());
        Assertions.assertEquals(new Result<Long>("00000", "success", Long.valueOf(1)), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme