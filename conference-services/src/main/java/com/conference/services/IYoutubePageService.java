package com.conference.services;

import java.util.List;

import com.conference.dataprovider.domain.YoutubePage;

public interface IYoutubePageService {
	public void createYoutubePage(YoutubePage youtubePage);
	public YoutubePage getYoutubePage(String id);
	public List<YoutubePage> getYoutubePages();
	public void updateYoutubePage(YoutubePage youtubePage);
	public void deleteYoutubePage(String id);
}
