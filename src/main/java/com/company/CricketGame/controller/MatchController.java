package com.company.CricketGame.controller;

import com.company.CricketGame.bean.MatchBean;
import com.company.CricketGame.dto.MatchCreationResponseDto;
import com.company.CricketGame.services.MatchService;
import com.company.CricketGame.util.MatchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping (value = "/startMatch")
    public MatchBean startNewMatch(@RequestBody MatchCreationResponseDto matchCreationResponse){
        boolean newMatchResponse = matchService.validateMatchCreationResponse(matchCreationResponse);
        MatchBean matchDetail = new MatchBean();
        if(newMatchResponse) {
            matchDetail = matchService.startMatch(matchCreationResponse);
            return matchDetail;
        }
        return matchDetail;
    }

    @GetMapping("/matchInfo/{matchId}")
    public ResponseEntity<MatchBean> getMatchInfo(@PathVariable Integer matchId){
        boolean matchInquiry = matchService.validateMatchId(matchId);
        MatchBean matchInfo = new MatchBean();
        if(matchInquiry){
            matchInfo= matchService.getMatchInfo(matchId);
        }
        return ResponseEntity.ok(matchInfo);
    }

    @GetMapping("/bulkMatchDetail/{frequency}")
    public ResponseEntity <Map<String, Long>> getBulkMatchDetail(@PathVariable int frequency){
        long[] responseTime = new long[frequency];
        long timeBeginning =System.currentTimeMillis();
        Map <String, Long> apiLoadDetails = new HashMap<String, Long>();
        long totalResponseTime =0;
        for(int i=0;i<frequency;i++){
            long apiStart = System.currentTimeMillis();
            String uri = "http://localhost:8080/match/matchInfo";
            RestTemplate restTemplate = new RestTemplate();
            MatchBean matchBean = restTemplate.getForObject(uri + "/39", MatchBean.class);
            long apiEnd = System.currentTimeMillis();
            responseTime[i] = apiEnd - apiStart;
            totalResponseTime += responseTime[i];
        }
        apiLoadDetails.put("averageResponseTime", totalResponseTime/frequency);
        apiLoadDetails.put("75 Percentile", MatchUtils.getPercentile(responseTime, 70));
        apiLoadDetails.put("90 Percentile", MatchUtils.getPercentile(responseTime, 90));
        apiLoadDetails.put("99 Percentile", MatchUtils.getPercentile(responseTime, 95));
        return ResponseEntity.ok(apiLoadDetails);
    }

    @GetMapping("/bulkMatchDetailThread/{frequency}")
    public ResponseEntity <Map<String, Long>> getBulkMatchDetailThread(@PathVariable int frequency){
        long[] responseTime = new long[frequency];
        long timeBeginning =System.currentTimeMillis();
        Map <String, Long> apiLoadDetails = new HashMap<String, Long>();
        long totalResponseTime =0;
        for(int i=0;i<frequency;i++){
            long apiStart = System.currentTimeMillis();

            multithreadingMatch object = new multithreadingMatch();
            object.start();

            long apiEnd = System.currentTimeMillis();
            responseTime[i] = apiEnd - apiStart;
            totalResponseTime += responseTime[i];
        }
        apiLoadDetails.put("averageResponseTime", totalResponseTime/frequency);
        apiLoadDetails.put("75 Percentile", MatchUtils.getPercentile(responseTime, 70));
        apiLoadDetails.put("90 Percentile", MatchUtils.getPercentile(responseTime, 90));
        apiLoadDetails.put("99 Percentile", MatchUtils.getPercentile(responseTime, 95));
        return ResponseEntity.ok(apiLoadDetails);
    }

    @GetMapping("/bulkMatchDetailThreadPool/{frequency}")
    public ResponseEntity <Map<String, Long>> getBulkMatchDetailThreadPool(@PathVariable int frequency){
        long[] responseTime = new long[frequency];
        long timeBeginning =System.currentTimeMillis();
        Map <String, Long> apiLoadDetails = new HashMap<String, Long>();
        long totalResponseTime =0;
        ExecutorService service = Executors.newFixedThreadPool(frequency);
        for(int i=0;i<frequency;i++){
            long apiStart = System.currentTimeMillis();

            service.execute(new Task());

            long apiEnd = System.currentTimeMillis();
            responseTime[i] = apiEnd - apiStart;
            totalResponseTime += responseTime[i];
        }
        apiLoadDetails.put("averageResponseTime", totalResponseTime/frequency);
        apiLoadDetails.put("75 Percentile", MatchUtils.getPercentile(responseTime, 70));
        apiLoadDetails.put("90 Percentile", MatchUtils.getPercentile(responseTime, 90));
        apiLoadDetails.put("99 Percentile", MatchUtils.getPercentile(responseTime, 95));
        return ResponseEntity.ok(apiLoadDetails);
    }

    @PostMapping("/bulkMatchPlay/{frequency}")
    public ResponseEntity <Map<String, Long>> getBulkMatchPlay(@PathVariable int frequency){
        long[] responseTime = new long[frequency];
        long timeBeginning =System.currentTimeMillis();
        Map <String, Long> apiLoadDetails = new HashMap<String, Long>();
        long totalResponseTime =0;
        MatchCreationResponseDto matchCreationResponse = new MatchCreationResponseDto("DC", "MI", "FIFTY_OVER","BATTING");
        for(int i=0;i<frequency;i++){
            long apiStart = System.currentTimeMillis();
            matchService.startMatch(matchCreationResponse);
            long apiEnd = System.currentTimeMillis();
            responseTime[i] = apiEnd - apiStart;
            totalResponseTime += responseTime[i];
        }
        apiLoadDetails.put("averageResponseTime", totalResponseTime/frequency);
        apiLoadDetails.put("75 Percentile", MatchUtils.getPercentile(responseTime, 70));
        apiLoadDetails.put("90 Percentile", MatchUtils.getPercentile(responseTime, 90));
        apiLoadDetails.put("99 Percentile", MatchUtils.getPercentile(responseTime, 95));
        return ResponseEntity.ok(apiLoadDetails);
    }

}

class Task implements Runnable {
    public void run(){
        try {
            String uri = "http://localhost:8080/match/matchInfo";
            RestTemplate restTemplate = new RestTemplate();
            MatchBean matchBean = restTemplate.getForObject(uri + "/34", MatchBean.class);
        }
        catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

class multithreadingMatch extends Thread {
    public void run()
    {
        try {
            String uri = "http://localhost:8080/match/matchInfo";
            RestTemplate restTemplate = new RestTemplate();
            MatchBean matchBean = restTemplate.getForObject(uri + "/15", MatchBean.class);
        }
        catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
