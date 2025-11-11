package pl.marros.choreapplication.chore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoreService {

    private final ChoreRepository choreRepository;
    //injecting chore repository into the chore service class
    @Autowired
    public ChoreService(ChoreRepository choreRepository){
        this.choreRepository = choreRepository;
    }
    //find all incomplete chores
    public List<ChoreEntity> findAllIncomplete(){
        return choreRepository.findAllByIsCompletedFalse();
    }
    //find all completed chores
    public List<ChoreEntity> findAllComplete(){
        return choreRepository.findAllByIsCompletedTrue();
    }


}
