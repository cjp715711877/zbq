package wang.ismy.zbq.service.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.ismy.zbq.model.dto.Page;
import wang.ismy.zbq.model.entity.action.Action;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTest {

    @Autowired
    ActionService actionService;

    @Test
    public void testSelect(){

        var list = actionService.pullActions(2,Page.of(1,5));


    }
}