package FunctionModule;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.FunctionModule;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class FunctionModuleController extends EntityController<FunctionModule> {
    @PostMapping("/functionModule")
    void createFunctionModule(FunctionModule functionModule){
        super.dataService.save(functionModule);
    }

    @GetMapping("/functionModule")
    FunctionModule getFunctionModule(UUID id){
        FunctionModule searchObj = new FunctionModule();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/functionModule")
    void updateFunctionModule(FunctionModule functionModule){
        super.dataService.save(functionModule);
    }

    @DeleteMapping("/functionModule")
    void deleteFunctionModule(UUID id){
        super.dataService.delete(getFunctionModule(id));
    }
}
