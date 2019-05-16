/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author caspe
 */
public class RequestURL {

    public List<String> runParallelCharacters() throws InterruptedException, ExecutionException {

        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

      //  create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();
        list.add(executor.submit(new FetchResourceCallable("https://dueinator.dk/jwtbackend/api/car/all")));
        executor.shutdown();
        List<String> urlStr = new ArrayList<>();
        for (Future<String> future : list) {
            urlStr.add(future.get());
        }
        return urlStr;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RequestURL ru = new RequestURL();
        List<String> ruq = ru.runParallelCharacters();
        System.out.println(ruq);
    }
}
    