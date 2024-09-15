package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.entity.Event;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    final EventDao eventDao;
    @Override
    public Integer getEventSize(){
        return eventDao.getEventSize();
    }
    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEventById(Long id) {
        return eventDao.getEventById(id);
    }
}
