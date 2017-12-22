/**
 * Copyright ®2017 Ebiz-Interactive<br/>
 * Package:  com.ebiz.threadPool<br/>
 * FileName: myThreadPool.java<br/>
 * Description: Ebiz-Unisys<br/>
 */
package com.ebiz.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.ebiz.threadPool.factory.ExecutorServiceFactory;

/**
 * 线程处理类
 *
 * @author cao.qifa 
 * @date 2017年12月14日 
 * @version 1.0
 */
public class ExecutorProcessPool {
    private ExecutorService executor;
    private static ExecutorProcessPool pool = new ExecutorProcessPool();
    private final int threadMax = 10;
    private ExecutorProcessPool() {
        System.out.println("threadMax>>>>>" + threadMax);
        executor = ExecutorServiceFactory.getInstance().createFixedThreadPool(threadMax);
    }
    public static ExecutorProcessPool getInstance() {
        return pool;
    }
    /**
     * 关闭线程池，这里要说明的是：调用关闭线程池方法后，线程池会执行完队列中的所有任务才退出
     * 
     * @author cao.qifa
     * @date 2017-12-14
     */
    public void shutdown(){
        executor.shutdown();
    }
    /**
     * 提交任务到线程池，可以接收线程返回值
     * 
     * @param task
     * @return
     * @author cao.qifa
     * @date 2017-12-14
     */
    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }
    
    /**
     * 提交任务到线程池，可以接受返回值
     *
     * @param task
     * @return
     * @date 2017年12月14日 
     */
    public Future<?> submit(Callable<?> task){
        return executor.submit(task);
    }
    
    /**
     * 直接提交任务到线程池，无返回值
     *
     * @param task
     * @date 2017年12月14日 
     */
    public void execute(Runnable task) {
        executor.execute(task);
    }
    
}
