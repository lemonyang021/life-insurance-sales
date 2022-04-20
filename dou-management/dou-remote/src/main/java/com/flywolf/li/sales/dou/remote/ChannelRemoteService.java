package com.flywolf.li.sales.dou.remote;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "channel-management")
public interface ChannelRemoteService {

    @GetMapping(value = "/channel/{channelId}")
    public Result<ChannelResponse> get(@PathVariable("channelId") Long channelId);


}
