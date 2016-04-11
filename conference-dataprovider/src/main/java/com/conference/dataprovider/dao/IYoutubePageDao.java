package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.dataprovider.domain.YoutubePage;

public interface IYoutubePageDao {
	public void createYoutubePage(YoutubePage youtubePage);
	public YoutubePage readYoutubePage(String id);
	public List<YoutubePage> readYoutubePages();
	public void updateYoutubePage(YoutubePage youtubePage);
	public void deleteYoutubePageById(String id);
}
