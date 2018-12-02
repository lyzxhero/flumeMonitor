package com.lyzx.flume;

import com.lyzx.flume.utils.Conf;
import com.lyzx.flume.utils.CommonUtils;
import com.lyzx.flume.utils.Result;

import java.util.Optional;

/**
 * @author hero.li
 *
 */
public class FlumeMonitor {

    public static void main(String[] args) {
        while(true){
            Optional<Result> request = CommonUtils.getRequest();
            if(!request.isPresent()){
                //报警
                System.out.println("报警。。。。1");
                continue;
            }

            Result result = request.get();
            if(result.getT1() != Conf.okCode){
                //报警
                System.out.println("报警。。。。2");
                continue;
            }


        }
    }
}
