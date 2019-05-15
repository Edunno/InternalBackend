/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author caspe
 */
public class FetchExecutor {

    List<String> urlStrs;

    public FetchExecutor(List<String> urlStr) {
        this.urlStrs = urlStr;
    }

    public List<String> run() throws InterruptedException, ExecutionException, TimeoutException {

        List<Future<String>> futuresList = new ArrayList();
        List<String> resultList = new ArrayList();

        ExecutorService exService = Executors.newCachedThreadPool();

        for (String urlStr : urlStrs) {
            Future<String> future = exService.submit(new FetchCallable(urlStr));
            futuresList.add(future);
        }

        for (Future<String> future : futuresList) {
            resultList.add(future.get());
        }

        exService.shutdown();

        return resultList;
    }

}
