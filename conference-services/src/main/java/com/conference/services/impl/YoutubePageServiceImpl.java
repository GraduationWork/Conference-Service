package com.conference.services.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.conference.core.domain.YoutubePage;
import com.conference.dataprovider.dao.IYoutubePageDao;
import com.conference.services.IYoutubePageService;

//@Service
//@Transactional
public class YoutubePageServiceImpl implements IYoutubePageService {

	private IYoutubePageDao youtubePageDao;
	
//	@Autowired
	public YoutubePageServiceImpl(IYoutubePageDao youtubePageDao) {
		Validate.notNull(youtubePageDao);
		this.youtubePageDao = youtubePageDao;
	}
	
	@Override
	public void createYoutubePage(YoutubePage youtubePage) {
		youtubePageDao.createYoutubePage(youtubePage);
	}

	@Override
	public YoutubePage getYoutubePage(String id) {
		return youtubePageDao.readYoutubePage(id);
	}

	@Override
	public List<YoutubePage> getYoutubePages() {
		return youtubePageDao.readYoutubePages();
	}

	@Override
	public void updateYoutubePage(YoutubePage youtubePage) {
		youtubePageDao.updateYoutubePage(youtubePage);
	}

	@Override
	public void deleteYoutubePage(String id) {
		youtubePageDao.deleteYoutubePageById(id);
	}

}
