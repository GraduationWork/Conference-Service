package com.conference.restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Component
@Path(OAuthCallbackResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class OAuthCallbackResources {

	private HttpClient httpCLient = HttpClientBuilder.create().build();
	
	public static final String RESOURCE_PATH = "oauth2callback";
	
	/** The name of the OAuth code URL parameter */
	public static final String CODE_URL_PARAM_NAME = "code";
	/** The name of the OAuth error URL parameter */
	public static final String ERROR_URL_PARAM_NAME = "error";
	/** The URL suffix of the servlet */
	public static final String URL_MAPPING = "/oauth2callback";
	public static final String REDIRECT_URL = "/";

	
	public static final String OAUTH_API = "https://accounts.google.com/o/oauth2/auth?client_id=698605801531-furmbme5fbdrt3njt95rrgrn4ed59vc0.apps.googleusercontent.com&redirect_uri=http://localhost:8083/conference-api/oauth2callback&scope=https://www.googleapis.com/auth/youtube&response_type=code&access_type=offline";
	
	
	@GET
	@Path("/youtube")
	public Response youtubeOAuthCallback(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		return null;
	}
	
	
	//Exchange tokens
	//POST https://developers.google.com/oauthplayground/exchangeAuthCode
	//{"token_uri":"https://www.googleapis.com/oauth2/v3/token","code":"4/sYp5ynE66WXCzraPpyo30jTa9dkfcQRAtTl9mFWy3ZE"}
	
	//Refresh token
	//POST https://developers.google.com/oauthplayground/refreshAccessToken
	//{"token_uri":"https://www.googleapis.com/oauth2/v3/token","refresh_token":"1/ZwDzePtSQlLw0qj1nMrKg3Z_tJMJ260eF-RnDXuo5lg"}
	
	
	
	
	
	/*
	 * public Response addUser(@FormParam("username") String username,
	 * 
	 * @FormParam("password") String password,
	 * 
	 * @FormParam("id") String id,
	 * 
	 * @FormParam("group_name") String groupName,
	 * 
	 * @FormParam("authority_name") String authorityName,
	 * 
	 * @FormParam("authority_id") String authorityId ) { //Something will be
	 * done here
	 * 
	 * java.net.URI location = new
	 * java.net.URI("../index.jsp?msg=A_User_Added"); return
	 * Response.temporaryRedirect(location).build()
	 * 
	 * }
	 */
	/*@GET
	public Response youtubeOAuthCallback(@Context UriInfo uriInfo,@Context HttpHeaders headers) {
		headers.getRequestHeader("conference-id");
		List<String> error = uriInfo.getQueryParameters().get(
				ERROR_URL_PARAM_NAME);
		if (error != null && error.size() > 0) {
			return Response.status(406)
					.entity("There was an error: \"" + error.get(0) + "\".")
					.build();
		}
		List<String> code = uriInfo.getQueryParameters().get(CODE_URL_PARAM_NAME);
		if (code == null || code.size() == 0) {
			return Response.status(400)
					.entity("The \"code\" URL parameter is missing").build();
		}
//		String requestUrl = getOAuthCodeCallbackHandlerUrl(req);
		return Response.ok("Success").build();
		
//		
//		AccessTokenResponse accessTokenResponse = exchangeCodeForAccessAndRefreshTokens(
//				code[0], requestUrl);
//		UserService userService = UserServiceFactory.getUserService();
//		String email = userService.getCurrentUser().getEmail();
//
//		// save token
//
//		java.net.URI location = new java.net.URI(
//				"../index.jsp?msg=A_User_Added");

	}
*/
	/*
	 * 
	 * 
	 * public static String getOAuthCodeCallbackHandlerUrl(HttpServletRequest
	 * req) { String scheme = req.getScheme() + "://"; String serverName =
	 * req.getServerName(); String serverPort = (req.getServerPort() == 80) ? ""
	 * : ":" + req.getServerPort(); String contextPath = req.getContextPath();
	 * String servletPath = URL_MAPPING; String pathInfo = (req.getPathInfo() ==
	 * null) ? "" : req.getPathInfo(); return scheme + serverName + serverPort +
	 * contextPath + servletPath + pathInfo; }
	 * 
	 * public AccessTokenResponse exchangeCodeForAccessAndRefreshTokens(String
	 * code, String currentUrl) throws IOException {
	 * 
	 * HttpTransport httpTransport = new NetHttpTransport(); JacksonFactory
	 * jsonFactory = new JacksonFactory();
	 * 
	 * // Loading the oauth config file OAuthProperties oauthProperties = new
	 * OAuthProperties();
	 * 
	 * return new GoogleAuthorizationCodeGrant(httpTransport, jsonFactory,
	 * oauthProperties .getClientId(), oauthProperties.getClientSecret(), code,
	 * currentUrl).execute(); }
	 */

}
