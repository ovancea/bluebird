package com.internship.bluebird.service;

import com.internship.bluebird.domain.BugEntity;
import com.internship.bluebird.dto.Bug;
import com.internship.bluebird.mapper.BugMapper;
import com.internship.bluebird.repo.BugRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BugService {

    private BugRepo bugRepo;
    private BugMapper bugMapper;
    private UserStoryService userStoryService;

    public BugService(BugRepo bugRepo, BugMapper bugMapper, UserStoryService userStoryService) {
        this.bugRepo = bugRepo;
        this.bugMapper = bugMapper;
        this.userStoryService = userStoryService;
    }

    public Bug create(Bug bug)
    {
        BugEntity bugEntity = bugMapper.businessObjectToEntity(bug);
        bugEntity.setUserStoryId(bug.getUserStory().getId());
        return bugMapper.entityToBusinessObject(bugRepo.save(bugEntity));
    }

    public Bug get(Integer id)
    {
        Optional<BugEntity> bugEntityOptional = bugRepo.findById(id);

        if (bugEntityOptional.isPresent()) {

            Bug savedBug = bugMapper.entityToBusinessObject(bugEntityOptional.get());
            savedBug.setUserStory(userStoryService.get(bugEntityOptional.get().getUserStoryId()));

            return savedBug;
        }

        throw new EntityNotFoundException();
    }

    public Bug update(Bug bug)
    {
        BugEntity bugEntity = bugMapper.businessObjectToEntity(bug);
        bugEntity.setUserStoryId(bug.getUserStory().getId());
        return bugMapper.entityToBusinessObject(bugRepo.save(bugEntity));
    }

    public void delete(Integer id)
    {
        bugRepo.deleteById(id);
    }

}
