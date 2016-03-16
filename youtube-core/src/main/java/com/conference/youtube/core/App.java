package com.conference.youtube.core;

import java.io.IOException;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CdnSettings;
import com.google.api.services.youtube.model.LiveBroadcast;
import com.google.api.services.youtube.model.LiveBroadcastSnippet;
import com.google.api.services.youtube.model.LiveBroadcastStatus;
import com.google.api.services.youtube.model.LiveStream;
import com.google.api.services.youtube.model.LiveStreamSnippet;
import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		YouTube youtube;
		List<String> scopes = Lists
				.newArrayList("https://www.googleapis.com/auth/youtube");
		Credential credential = Auth.authorize(scopes, "createbroadcast");
		youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY,
				credential).setApplicationName(
				"youtube-cmdline-createbroadcast-sample").build();

		String title = "Stream test from Java";
		System.out.println("You chose " + title + " for broadcast title.");

		// Create a snippet with the title and scheduled start and end
        // times for the broadcast. Currently, those times are hard-coded.
        LiveBroadcastSnippet broadcastSnippet = new LiveBroadcastSnippet();
        broadcastSnippet.setTitle(title);
        broadcastSnippet.setScheduledStartTime(new DateTime("2024-01-30T00:00:00.000Z"));
        broadcastSnippet.setScheduledEndTime(new DateTime("2024-01-31T00:00:00.000Z"));
        
        LiveBroadcastStatus status = new LiveBroadcastStatus();
        status.setPrivacyStatus("private");
        
        LiveBroadcast broadcast = new LiveBroadcast();
        broadcast.setKind("youtube#liveBroadcast");
        broadcast.setSnippet(broadcastSnippet);
        broadcast.setStatus(status);
        
        YouTube.LiveBroadcasts.Insert liveBroadcastInsert =
                youtube.liveBroadcasts().insert("snippet,status", broadcast);
        LiveBroadcast returnedBroadcast = liveBroadcastInsert.execute();
        
     // Print information from the API response.
        System.out.println("\n================== Returned Broadcast ==================\n");
        System.out.println("  - Id: " + returnedBroadcast.getId());
        System.out.println("  - Title: " + returnedBroadcast.getSnippet().getTitle());
        System.out.println("  - Description: " + returnedBroadcast.getSnippet().getDescription());
        System.out.println("  - Published At: " + returnedBroadcast.getSnippet().getPublishedAt());
        System.out.println(
                "  - Scheduled Start Time: " + returnedBroadcast.getSnippet().getScheduledStartTime());
        System.out.println(
                "  - Scheduled End Time: " + returnedBroadcast.getSnippet().getScheduledEndTime());
        
        LiveStreamSnippet streamSnippet = new LiveStreamSnippet();
        streamSnippet.setTitle(title);
        
        CdnSettings cdnSettings = new CdnSettings();
        cdnSettings.setFormat("1080p");
        cdnSettings.setIngestionType("rtmp");

        LiveStream stream = new LiveStream();
        stream.setKind("youtube#liveStream");
        stream.setSnippet(streamSnippet);
        stream.setCdn(cdnSettings);
        
        YouTube.LiveStreams.Insert liveStreamInsert =
                youtube.liveStreams().insert("snippet,cdn", stream);
        LiveStream returnedStream = liveStreamInsert.execute();

        
        // Construct and execute a request to bind the new broadcast
        // and stream.
        YouTube.LiveBroadcasts.Bind liveBroadcastBind =
                youtube.liveBroadcasts().bind(returnedBroadcast.getId(), "id,contentDetails");
        liveBroadcastBind.setStreamId(returnedStream.getId());
        returnedBroadcast = liveBroadcastBind.execute();
        
        // Print information from the API response.
        System.out.println("\n================== Returned Bound Broadcast ==================\n");
        System.out.println("  - Broadcast Id: " + returnedBroadcast.getId());
        System.out.println(
                "  - Bound Stream Id: " + returnedBroadcast.getContentDetails().getBoundStreamId());
        
        
		
	}
}
