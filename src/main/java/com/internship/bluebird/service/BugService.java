package com.internship.bluebird.service;

import com.internship.bluebird.domain.BugEntity;
import com.internship.bluebird.dto.Bug;
import com.internship.bluebird.dto.User;
import com.internship.bluebird.mapper.BugMapper;
import com.internship.bluebird.repo.BugRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    private BugRepo bugRepo;
    private BugMapper bugMapper;

    public BugService(BugRepo bugRepo, BugMapper bugMapper) {
        this.bugRepo = bugRepo;
        this.bugMapper = bugMapper;
    }

    public Bug create(Bug bug)
    {
        BugEntity bugEntity = bugMapper.businessObjectToEntity(bug);
        return bugMapper.entityToBusinessObject(bugRepo.save(bugEntity));
    }

    public List<Bug> create(List<Bug> bugList)
    {
        List<BugEntity> bugEntityList = bugMapper.businessObjectsToEntities(bugList);
        return bugMapper.entitiesToBusinessObject(bugRepo.saveAll(bugEntityList));
    }

    public Bug get(Integer id)
    {
        Optional<BugEntity> bugEntityOptional = bugRepo.findById(id);

        if (bugEntityOptional.isPresent()) {

            return bugMapper.entityToBusinessObject(bugEntityOptional.get());

        }

        throw new EntityNotFoundException();
    }

    public List<Bug> findByUserStoryId(Integer id)
    {
        List<Bug> bugList = bugMapper.entitiesToBusinessObject(bugRepo.findByUserStoryId(id));
        return bugList;
    }

    public List<Bug> findByUserId(Integer id)
    {
        List<Bug> bugList = bugMapper.entitiesToBusinessObject(bugRepo.findByUserId(id));
        return bugList;
    }

    public Bug update(Bug bug)
    {
        BugEntity bugEntity = bugMapper.businessObjectToEntity(bug);
        return bugMapper.entityToBusinessObject(bugRepo.save(bugEntity));
    }

    public void delete(Integer id)
    {
        bugRepo.deleteById(id);
    }

    public void deleteByUserStoryId(Integer id)
    {
        bugRepo.deleteByUserStoryId(id);
    }

    public void deleteByUserId(Integer id)
    {
        bugRepo.deleteByUserId(id);
    }

}
