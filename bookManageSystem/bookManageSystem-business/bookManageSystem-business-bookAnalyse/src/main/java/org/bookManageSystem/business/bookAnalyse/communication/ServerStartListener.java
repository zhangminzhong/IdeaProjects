package org.bookManageSystem.business.bookAnalyse.communication;

import org.bookManageSystem.business.bookAnalyse.service.BookAnalyseService;
import org.bookManageSystem.fundamental.logger.FundamentalLogger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-1-1
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */
public class ServerStartListener implements ServletContextListener {
    private Timer timer;
    private BookAnalyseService bookAnalyseService;
    private WebApplicationContext context;
    private static final FundamentalLogger logger = FundamentalLogger.getLogger(ServerStartListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        context = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        bookAnalyseService = (BookAnalyseService)context.getBean("bookAnalyseService");
        timer = new Timer(true);
        logger.info("定时器已启动");
        timer.schedule(new BookAnalyseTask(bookAnalyseService),0,60000);
        logger.info("已添加到任务调度表");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
        logger.info("销毁定时器");
    }
}
