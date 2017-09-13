package org.aerogear.digger.test;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * We have this class to hold all data related to testing.
 * The reason that we have it is we want to externalize these data.
 * Also, this approach would make the code extendable.
 **/
@Getter
public class DiggerTestingEnv {

    private static final Logger LOG = LoggerFactory.getLogger(DiggerTestingEnv.class);

    protected String prefix;
    protected String diggerTargetUrl;
    protected String diggerUsername;
    protected String diggerPassword;

    public void initialize() {
        LOG.debug("Reading Digger testing environment parameters");

        this.prefix = System.getProperty("prefix");
        this.diggerTargetUrl = System.getProperty("diggerTargetUrl");
        this.diggerUsername = System.getProperty("diggerUsername");
        this.diggerPassword = System.getProperty("diggerPassword");

        LOG.debug("Here are env: prefix={}, diggerTargetUrl={}, diggerUsername={}, diggerPassword={}",
                this.prefix, this.diggerTargetUrl, this.diggerUsername, this.diggerPassword);

        if (StringUtils.isBlank(diggerTargetUrl)) {
            throw new RuntimeException("diggerTargetUrl is required");
        }
    }
}