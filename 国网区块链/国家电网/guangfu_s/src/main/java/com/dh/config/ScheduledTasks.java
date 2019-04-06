package com.dh.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dh.guangfu.service.IntegralService;
import com.dh.guangfu.service.ProductionElectricityService;
import com.dh.guangfu.service.TrafficElectricityService;
import com.dh.guangfu.service.UserTotalService;
import com.dh.system.base.BaseController;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks  extends BaseController{

//    @Scheduled(fixedRate = 1000 * 10)
//    public void reportCurrentTime(){
//        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
//    }
	@Autowired
	private TrafficElectricityService TrafficElectricityService;//上网量
	@Autowired
	private IntegralService IntegralService;//积分
	@Autowired
	private ProductionElectricityService ProductionElectricityService;//发电量
	@Autowired
	private UserTotalService userTotalService;
	
    //每1分钟执行一次
    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron(){
//    		Random random=	new Random();
//    		TrafficElectricity trafficElectricity=new TrafficElectricity(24L,random.nextInt(10)*2L);
//    		TrafficElectricityService.save(trafficElectricity);
//    		
//    		BigDecimal bigd=new BigDecimal(random.nextInt(10)*2L);
//    		Integral integral=new Integral(24L,bigd,1);
//    		
//    		IntegralService.save(integral);
//    		
//    		ProductionElectricity productionElectricity=new ProductionElectricity(24L,random.nextInt(10)*2L);
//    		ProductionElectricityService.save(productionElectricity);
//    		
//    		
//    		UserTotal userTotal=userTotalService.fingByUserId(24L);
//    		if(null!=userTotal){
//    			userTotal.setUser_id(24L);
//    			userTotal.setTotal_integral(userTotal.getTotal_integral().add(integral.getNum()));
//    			userTotal.setTotal_electricity(userTotal.getTotal_electricity().add(new BigDecimal(productionElectricity.getNum())));
//    			userTotal.setTotal_traffic(userTotal.getTotal_traffic().add(new BigDecimal(trafficElectricity.getNum())));
//    			userTotalService.update(userTotal);
//    		}else{
//    			 userTotal=new UserTotal();
//    			 userTotal.setUser_id(24L);
//    			userTotal.setTotal_integral(integral.getNum());
//    			userTotal.setTotal_electricity(new BigDecimal(productionElectricity.getNum()));
//    			userTotal.setTotal_traffic(new BigDecimal(trafficElectricity.getNum()));
//    			userTotalService.save(userTotal);
//    		}
    		System.out.println ("数据生成器" + dateFormat ().format (new Date ()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
    
}