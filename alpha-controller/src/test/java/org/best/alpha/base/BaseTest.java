package org.best.alpha.base;

import org.best.alpha.config.RootConfig;
import org.best.alpha.config.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class})
@EnableTransactionManagement
@Transactional(rollbackFor = {Exception.class})
@Rollback
public class BaseTest {
}
