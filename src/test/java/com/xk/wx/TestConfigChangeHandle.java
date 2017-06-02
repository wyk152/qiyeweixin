package com.xk.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xk.wx.api.config.ConfigChangeNotice;
import com.xk.wx.handle.AbstractApiConfigChangeHandle;

/**
 * @author peiyu
 */
public class TestConfigChangeHandle extends AbstractApiConfigChangeHandle {

    private static final Logger LOG = LoggerFactory.getLogger(TestConfigChangeHandle.class);

    @Override
    public void configChange(ConfigChangeNotice notice) {
        LOG.debug("收到通知.....");
        LOG.debug(notice.toJsonString());
    }
}
