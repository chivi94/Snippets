import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileFromUrlSnippet {

	final static String URL = "http://www.vaxasoftware.com/doc_edu/mat/infiequi.pdf";

	/**
	 * Method to download a file from URL
	 * 
	 * @param urlStr
	 *            The Url to download the file
	 */
	public static void downloadUsingStream(String urlStr) {
		URL url;
		BufferedInputStream bis = null;
		FileOutputStream fis = null;
		try {
			url = new URL(urlStr);
			bis = new BufferedInputStream(url.openStream());
			fis = new FileOutputStream(urlStr.substring(
					urlStr.lastIndexOf("/") + 1, urlStr.length()));
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = bis.read(buffer, 0, 1024)) != -1) {
				fis.write(buffer, 0, count);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Method to download a file from URL
	 * 
	 * @param urlStr
	 *            The Url to download the file
	 */
	public static void downloadUsingNIO(String urlStr) {
		URL url;
		ReadableByteChannel rbc = null;
		FileOutputStream fos = null;
		try {
			url = new URL(urlStr);
			rbc = Channels.newChannel(url.openStream());
			fos = new FileOutputStream(urlStr.substring(
					urlStr.lastIndexOf("/") + 1, urlStr.length()));
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (rbc != null) {
					rbc.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Method to download a file from URL
	 * 
	 * @param urlStr
	 *            The Url to download the file
	 */
	public static void downloadUsingHttpUrlConnection(String urlStr) {
		int buffer_size = 1024;
		URL url;
		HttpURLConnection httpConn = null;
		try {
			url = new URL(urlStr);
			httpConn = (HttpURLConnection) url.openConnection();
			int responseCode = httpConn.getResponseCode();
			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
				String fileName = "";
				String disposition = httpConn
						.getHeaderField("Content-Disposition");
				String contentType = httpConn.getContentType();
				int contentLength = httpConn.getContentLength();

				if (disposition != null) {
					// extracts file name from header field
					int index = disposition.indexOf("filename=");
					if (index > 0) {
						fileName = disposition.substring(index + 10,
								disposition.length() - 1);
					}
				} else {
					// extracts file name from URL
					fileName = urlStr.substring(urlStr.lastIndexOf("/") + 1,
							urlStr.length());
				}

				System.out.println("Content-Type = " + contentType);
				System.out.println("Content-Disposition = " + disposition);
				System.out.println("Content-Length = " + contentLength);
				System.out.println("fileName = " + fileName);

				// opens input stream from the HTTP connection
				InputStream inputStream = httpConn.getInputStream();
				// String saveFilePath = saveDir + File.separator + fileName;

				// opens an output stream to save into file
				FileOutputStream outputStream = new FileOutputStream(fileName);

				int bytesRead = -1;
				byte[] buffer = new byte[buffer_size];
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				outputStream.close();
				inputStream.close();

				System.out.println("File downloaded");
			} else {
				System.out
						.println("No file to download. Server replied HTTP code: "
								+ responseCode);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
		}

	}

	public static void main(String args[]) {
		downloadUsingStream(URL);
		downloadUsingNIO(URL);
		downloadUsingHttpUrlConnection(URL);
	}

}
