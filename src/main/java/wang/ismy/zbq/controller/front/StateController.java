package wang.ismy.zbq.controller.front;

import org.apache.ibatis.annotations.Result;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.zbq.annotations.MustLogin;
import wang.ismy.zbq.annotations.ResultTarget;
import wang.ismy.zbq.dto.Page;
import wang.ismy.zbq.dto.StateCommentDTO;
import wang.ismy.zbq.dto.StateDTO;
import wang.ismy.zbq.resources.StringResources;
import wang.ismy.zbq.service.StateService;
import wang.ismy.zbq.util.ErrorUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @PutMapping("")
    @ResultTarget
    @MustLogin
    public Object publishState(@RequestBody @Valid StateDTO stateDTO){
        stateService.currentUserPublishState(stateDTO);
        return StringResources.STATE_PUBLISH_SUCCESS;
    }

    @GetMapping("/self")
    @ResultTarget
    @MustLogin
    public Object getCurrentUserStates(@RequestParam("page") Integer pageNo, @RequestParam("length")Integer length){
        Page p = new Page();
        p.setPageNumber(pageNo);
        p.setLength(length);
        return stateService.selectCurrentUserStatePaging(p);
    }

    @GetMapping("/self/count")
    @ResultTarget
    @MustLogin
    public Object countSelfState(){
        return stateService.countSelfState();
    }

    @PutMapping("/comment")
    @ResultTarget
    @MustLogin
    public Object createCurrentUserStateComment(@Valid @RequestBody StateCommentDTO stateCommentDTO){
        if (stateService.createCurrentUserStateComment(stateCommentDTO) == 1){
            return "评论成功";
        }
        return "评论失败";
    }

    @DeleteMapping("/{stateId}")
    @ResultTarget
    @MustLogin
    public Object deleteState(@PathVariable Integer stateId){
        if (stateService.deleteCurrentUserStateById(stateId) != 1){
            ErrorUtils.error(StringResources.DELETE_STATE_FAIL);
        }
        return StringResources.DELETE_STATE_SUCCESS ;
    }
}
