package net.silvacarvalho.marlon.conectividade;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static final String doGet(final String url) {
		String result = null;

		try {
			final URI uri = new URI(url);
			final HttpGet httpGet = new HttpGet(uri);
			final HttpClient httpClient = new DefaultHttpClient();

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {

					HttpEntity entity = response.getEntity();
					return EntityUtils.toString(entity);
				}

			};

			result = httpClient.execute(httpGet, responseHandler);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
