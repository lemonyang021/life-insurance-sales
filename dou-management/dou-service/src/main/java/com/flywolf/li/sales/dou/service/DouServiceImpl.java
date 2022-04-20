package com.flywolf.li.sales.dou.service;

import com.flywolf.li.framework.dto.Result;
import com.flywolf.li.framework.util.ConvertUtil;
import com.flywolf.li.sales.channel.dto.resp.ChannelResponse;
import com.flywolf.li.sales.dou.entity.Dou;
import com.flywolf.li.sales.dou.remote.ChannelRemoteService;
import com.flywolf.li.sales.dou.repository.DouRepository;
import com.flywolf.li.sales.dou.service.bo.DouBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class DouServiceImpl implements DouService {
    @Resource
    DouRepository douRepository;

    @Resource
    ChannelRemoteService channelRemoteService;

    @Override
    public Long register(DouBO bo) {
        Dou dou = ConvertUtil.convert(bo, Dou.class);
        ConvertUtil.initInsertEntity(dou);
        douRepository.save(dou);
        return dou.getId();
    }

    @Override
    public void update(DouBO bo) {
        Dou dou = ConvertUtil.convert(bo, Dou.class);
        ConvertUtil.initUpdateEntity(dou);
        douRepository.save(dou);
    }

    @Override
    public void delete(Long douid) {
        douRepository.deleteById(douid);
    }

    @Override
    public DouBO findById(Long douid) {
        //Dou dou = douRepository.findById(douid).get();
        Result<ChannelResponse> result=channelRemoteService.get(15L);
        log.info(result.getData().toString());
        return ConvertUtil.convert(new Dou(), DouBO.class);
    }

    @Override
    public List<DouBO> findAll() {
        List<Dou> douList = douRepository.findAll();
        return ConvertUtil.convert(douList, DouBO.class);
    }
}
