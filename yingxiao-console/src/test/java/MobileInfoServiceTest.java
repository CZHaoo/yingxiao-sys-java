import com.zhijian.market.console.MarketConsoleApplication;
import com.zhijian.market.console.service.MobileInfoService;
import com.zhijian.market.core.dto.mobileinfo.MobileInfoDto;
import com.zhijian.market.core.pojo.MobileInfo;
import com.zhijian.market.core.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarketConsoleApplication.class)
public class MobileInfoServiceTest {

    @Autowired
    private MobileInfoService mobileInfoService;

    @Test
    public void deleteTest() {
        MobileInfoDto.DeleteReq deleteReq = new MobileInfoDto.DeleteReq();
        Integer[] ids= {1,2};
        deleteReq.setIds(ids);
        mobileInfoService.delete(deleteReq);
    }


    @Test
    public void updateTest() {
        MobileInfoDto.UpdateReq updateReq = new MobileInfoDto.UpdateReq();
        MobileInfo mobileInfo = new MobileInfo();
        mobileInfo.setId(1);
        mobileInfo.setMobile("123");
        updateReq.setData(mobileInfo);
        mobileInfoService.update(updateReq);
    }

    @Test
    public void oneTest() {
        System.out.println(JsonUtil.beanToJson(mobileInfoService.one(3)));

    }


}
